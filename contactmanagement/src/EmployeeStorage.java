import com.google.gson.*;
import java.io.*;
import java.util.ArrayList;

public class EmployeeStorage {
    // dir path
    private static final String FILE_NAME = "employee.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    // Simpan data karyawan ke file JSON
    public static void saveEmployees(ArrayList<Employee> employees) {
        try (Writer writer = new FileWriter(FILE_NAME)) {
            gson.toJson(employees, writer);
        } catch (IOException e) {
            System.out.println("Gagal menyimpan data karyawan: " + e.getMessage());
        }
    }

    // Load data karyawan dari file JSON
    public static ArrayList<Employee> loadEmployees() {
        ArrayList<Employee> result = new ArrayList<>();

        File file = new File(FILE_NAME);
        // buat file kosong kalau tidak ada
        if (!file.exists()) {
            saveEmployees(result);
            return result;
        }

        try (Reader reader = new FileReader(file)) {
            JsonArray jsonArray = JsonParser.parseReader(reader).getAsJsonArray();
            for (JsonElement element : jsonArray) {
                JsonObject obj = element.getAsJsonObject();
                JsonElement typeElement = obj.get("type");

                Employee emp;
                if (typeElement == null) {
                    emp = gson.fromJson(obj, Employee.class);
                } else {
                    String type = typeElement.getAsString().toLowerCase();
                    switch (type) {
                        case "manager":
                            emp = gson.fromJson(obj, Manager.class);
                            break;
                        case "staff":
                            emp = gson.fromJson(obj, Staff.class);
                            break;
                        default:
                            emp = gson.fromJson(obj, Employee.class);
                    }
                }

                result.add(emp);
            }
        } catch (IOException e) {
            System.out.println("Gagal memuat data karyawan: " + e.getMessage());
        } catch (JsonSyntaxException | IllegalStateException e) {
            System.out.println("Format JSON tidak valid: " + e.getMessage());
        }

        return result;
    }
}
