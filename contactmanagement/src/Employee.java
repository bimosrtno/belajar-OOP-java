public class Employee {
    protected String name;
    protected String phone;
    protected String email;

public Employee() {}

    public Employee(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;

    }

    public void displayInfo() {
        System.out.println("nama: " + name);
        System.out.println("phone: " + phone);
        System.out.println("email: " + email);
    }
}
