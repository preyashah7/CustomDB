import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        KeyValueStore<String, String> store = new KeyValueStore<>(3);  // LRU Cache capacity = 3
        store.loadFromFile("data.json"); // or "data.json" if using Gson later


        System.out.println(" Welcome to the Key-Value Store with LRU Cache");
        System.out.println("----------------------------------------------");

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. PUT key value");
            System.out.println("2. GET key");
            System.out.println("3. DELETE key");
            System.out.println("4. EXIT");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter key: ");
                    String putKey = scanner.nextLine();

                    System.out.print("Enter value: ");
                    String putValue = scanner.nextLine();

                    store.put(putKey, putValue);
                    break;

                case 2:
                    System.out.print("Enter key: ");
                    String getKey = scanner.nextLine();
                    String value = store.get(getKey);
                    if (value == null) {
                        System.out.println("Result: Key not found.");
                    } else {
                        System.out.println("Result: " + value);
                    }
                    break;

                case 3:
                    System.out.print("Enter key to delete: ");
                    String delKey = scanner.nextLine();
                    store.delete(delKey);
                    break;

                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
