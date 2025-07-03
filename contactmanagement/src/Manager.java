public class Manager extends Employee{
    private String department;

    public Manager(String name, String phone,String email, String department) {
        super (name, phone, email);
        this.department = department;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Jabatan : manager");
        System.out.println("Department :" + department);
    }
}
