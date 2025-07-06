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
            sc.nextLine(); // konsumsi newline

            switch (choice) {
                case 1:
                    service.showAll();
                    System.out.println("1. Kembali ke menu utama");
                    System.out.print("Pilih: ");
                    sc.nextLine(); // tunggu input user
                    break;
                case 2:
                    System.out.print("Nama   : ");
                    String nameS = sc.nextLine();
                    System.out.print("Phone  : ");
                    String phoneS = sc.nextLine();
                    System.out.print("Email  : ");
                    String emailS = sc.nextLine();
                    System.out.print("Divisi : ");
                    String div = sc.nextLine();
                    service.addEmployee(new Staff(nameS, phoneS, emailS, div));
                    break;
                case 3:
                    System.out.print("Nama       : ");
                    String nameM = sc.nextLine();
                    System.out.print("Phone      : ");
                    String phoneM = sc.nextLine();
                    System.out.print("Email      : ");
                    String emailM = sc.nextLine();
                    System.out.print("Department : ");
                    String dept = sc.nextLine();
                    service.addEmployee(new Manager(nameM, phoneM, emailM, dept));
                    break;
                case 4:
                    service.showAll();
                    System.out.print("Index karyawan yang mau diupdate: ");
                    int idxUpdate = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nama baru  : ");
                    String nameU = sc.nextLine();
                    System.out.print("Phone baru : ");
                    String phoneU = sc.nextLine();
                    System.out.print("Email baru : ");
                    String emailU = sc.nextLine();
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
}
