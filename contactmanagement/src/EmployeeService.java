import java.util.ArrayList;

public class EmployeeService {
    private ArrayList<Employee> employees = new ArrayList<>();

    public void addEmployee (Employee emp) {
        employees.add(emp);
    }
    public void showAllEmployees () {
        for (Employee emp : employees) {
            System.out.println("------------------------");
            emp.displayInfo();
        }
    }
}