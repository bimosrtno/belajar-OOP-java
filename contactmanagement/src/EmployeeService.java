import java.util.ArrayList;

public class EmployeeService {
    private ArrayList<Employee> employees = new ArrayList<>();

    public void load() {
        this.employees = EmployeeStorage.loadEmployees();
    }

    public void save() {
        EmployeeStorage.saveEmployees(employees);
    }

    public void addEmployee(Employee emp) {
        employees.add(emp);
        save();
    }

    public void showAll() {
        for (int i = 0; i < employees.size(); i++) {
            System.out.println("[" + i + "]");
            employees.get(i).displayInfo();
            System.out.println("--------------------------");
        }
    }

    public void deleteEmployee(int index) {
        if (index >= 0 && index < employees.size()) {
            employees.remove(index);
            save();
        } else {
            System.out.println("Index tidak valid.");
        }
    }

    public void updateEmployee(int index, String name, String phone, String email) {
        if (index >= 0 && index < employees.size()) {
            Employee emp = employees.get(index);
            emp.setName(name);
            emp.setPhone(phone);
            emp.setEmail(email);
            save();
        } else {
            System.out.println("Index tidak valid.");
        }
    }
}
