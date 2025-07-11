import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeService service = new EmployeeService();
        service.load();

        while (true) {
            System.out.println("\n=== MENU UTAMA ===");
            System.out.println("1. List karyawan");
            System.out.println("2. Tambah Staff");
            System.out.println("3. Tambah Manager");
            System.out.println("4. Update karyawan");
            System.out.println("5. Hapus karyawan");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    service.showAll();
                    System.out.println("1. Kembali ke menu utama");
                    System.out.print("Pilih: ");
                    sc.nextLine();
                    break;

                case 2:
                    String nameS = inputNotEmpty(sc, "Nama");
                    String phoneS = inputNotEmpty(sc, "Phone");
                    String emailS = inputEmail(sc);
                    String div = inputNotEmpty(sc, "Divisi");

                    service.addEmployee(new Staff(nameS, phoneS, emailS, div));
                    break;

                case 3:
                    String nameM = inputNotEmpty(sc, "Nama");
                    String phoneM = inputNotEmpty(sc, "Phone");
                    String emailM = inputEmail(sc);
                    String dept = inputNotEmpty(sc, "Department");

                    service.addEmployee(new Manager(nameM, phoneM, emailM, dept));
                    break;

                case 4:
                    service.showAll();
                    System.out.print("Index karyawan yang mau diupdate: ");
                    int idxUpdate = sc.nextInt();
                    sc.nextLine();
                    String nameU = inputNotEmpty(sc, "Nama baru");
                    String phoneU = inputNotEmpty(sc, "Phone baru");
                    String emailU = inputEmail(sc);
                    service.updateEmployee(idxUpdate, nameU, phoneU, emailU);
                    break;

                case 5:
                    service.showAll();
                    System.out.print("Index karyawan yang mau dihapus: ");
                    int idxDelete = sc.nextInt();
                    sc.nextLine();
                    service.deleteEmployee(idxDelete);
                    break;

                case 0:
                    System.out.println("Keluar dari program.");
                    return;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    // validasi

    private static String inputNotEmpty(Scanner sc, String label) {
        String input;
        while (true) {
            System.out.print(label + " : ");
            input = sc.nextLine();
            if (!input.trim().isEmpty()) {
                return input;
            } else {
                System.out.println(label + " tidak boleh kosong");
            }
        }
    }


    private static String inputEmail(Scanner sc) {
        String email;
        while (true) {
            System.out.print("Email : ");
            email = sc.nextLine();
            if (email.contains("@") && email.contains(".")) {
                return email;
            } else {
                System.out.println("format email tidak valid");
            }
        }
    }
}
