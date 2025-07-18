import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;

public class PersistenceManager {

    private static final Gson gson = new Gson();

    public static <K, V> void saveToFile(HashMap<K, V> data, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            gson.toJson(data, writer);
            System.out.println("Data saved to " + filename);
        } catch (IOException e) {
            System.out.println("Error saving: " + e.getMessage());
        }
    }

    public static <K, V> HashMap<K, V> loadFromFile(String filename) {
        try (FileReader reader = new FileReader(filename)) {
            Type type = new TypeToken<HashMap<K, V>>() {}.getType();
            HashMap<K, V> data = gson.fromJson(reader, type);
            System.out.println("Data loaded from " + filename);
            return data != null ? data : new HashMap<>();
        } catch (IOException e) {
            System.out.println("Could not load file, starting fresh.");
            return new HashMap<>();
        }
    }
}
