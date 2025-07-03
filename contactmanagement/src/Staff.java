public class Staff extends Employee {
    public String division;

    public Staff (String name, String phone, String email, String division) {
        super(name, phone, email);
        this.division = division;
    }
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Jabatan : staff");
        System.out.println("divisi : " + division);
    }
}
