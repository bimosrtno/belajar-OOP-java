import com.google.gson.*;
import java.io.*;
import java.util.ArrayList;

public class EmployeeStorage {
    private static final String FILE_NAME = "employee.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void saveEmployees(ArrayList<Employee> employees) {
        try (Writer writer = new FileWriter(FILE_NAME)) {
            gson.toJson(employees, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Employee> loadEmployees() {
        ArrayList<Employee> result = new ArrayList<>();
        try (Reader reader = new FileReader(FILE_NAME)) {
            JsonArray jsonArray = JsonParser.parseReader(reader).getAsJsonArray();
            for (JsonElement element : jsonArray) {
                JsonObject obj = element.getAsJsonObject();
                JsonElement typeElement = obj.get("type");

                if (typeElement == null) {
                    result.add(gson.fromJson(obj, Employee.class));
                    continue;
                }

                String type = typeElement.getAsString();

                Employee emp;
                switch (type.toLowerCase()) {
                    case "manager":
                        emp = gson.fromJson(obj, Manager.class);
                        break;
                    case "staff":
                        emp = gson.fromJson(obj, Staff.class);
                        break;
                    default:
                        emp = gson.fromJson(obj, Employee.class);
                }

                result.add(emp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
