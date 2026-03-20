import java.util.HashMap;
import java.util.Map;

public class TrainConsistManagementApp {

    public static void main(String[] args) {
        // Welcome message
        System.out.println("=== Train Consist Management App ===");
        System.out.println("UC6: Map Bogie to Capacity (HashMap)");

        // Step 1: Create HashMap
        HashMap<String, Integer> bogieCapacityMap = new HashMap<>();

        // Step 2: Insert bogie and capacity
        bogieCapacityMap.put("Sleeper", 72);
        bogieCapacityMap.put("AC Chair", 60);
        bogieCapacityMap.put("First Class", 40);
        bogieCapacityMap.put("Goods Rectangular", 100);
        bogieCapacityMap.put("Goods Cylindrical", 80);

        // Step 3: Display bogie capacity using entrySet()
        System.out.println("\nBogie Capacity Details:");

        for (Map.Entry<String, Integer> entry : bogieCapacityMap.entrySet()) {
            System.out.println("Bogie: " + entry.getKey() +
                    " | Capacity: " + entry.getValue());
        }

        // Program continues
        System.out.println("\nProgram continues...");
    }
}