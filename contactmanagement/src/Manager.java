public class Manager extends Employee {
    private String department;

    public Manager() {}

    public Manager(String name, String phone, String email, String department) {
        super(name, phone, email);
        this.department = department;
        this.type = "manager";
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Jabatan    : Manager");
        System.out.println("Department : " + department);
    }
}
