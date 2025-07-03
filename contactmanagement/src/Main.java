public class Main {
    public static void main (String[] args) {
        EmployeeService service = new EmployeeService();

        Manager mgrIT = new Manager("bambang", "08123123123", "bambang@mail.com", "IT");
        Manager mgrLegal = new Manager("budi", "084123123", "budi@mail.com", "Legal");
        Staff s1 = new Staff("munaroh", "087123221", "munaroh@mail.com", "marketing");
        Staff s2 = new Staff("adam", "087711221", "adam@mail.com", "collector");

        service.addEmployee(mgrIT);
        service.addEmployee(mgrLegal);
        service.addEmployee(s1);
        service.addEmployee(s2);

        service.showAllEmployees();
    }
}