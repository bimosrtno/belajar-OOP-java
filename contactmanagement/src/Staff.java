public class Staff extends Employee {
    private String division;

    public Staff() {}

    public Staff(String name, String phone, String email, String division) {
        super(name, phone, email);
        this.division = division;
        this.type = "staff";
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Jabatan : Staff");
        System.out.println("Divisi  : " + division);
    }
}

