public class Employee {
    protected String name;
    protected String phone;
    protected String email;
    protected String type;

    public Employee() {
        this.type = "employee"; // default jika dari JSON tanpa type
    }

    public Employee(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.type = "employee";
    }

    public void displayInfo() {
        System.out.println("Nama  : " + name);
        System.out.println("Phone : " + phone);
        System.out.println("Email : " + email);
    }

    public String getName() { return name; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }
    public String getType() { return type; }

    public void setName(String name) { this.name = name; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setEmail(String email) { this.email = email; }
    public void setType(String type) { this.type = type; }

    @Override
    public String toString() {
        return name + " (" + type + ")";
    }
}
