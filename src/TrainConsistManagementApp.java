import java.util.ArrayList;
import java.util.List;

/**
 * Use Case 10: Count Total Seats in Train
 * Aggregates seating capacity of all bogies into a single total using Stream reduce().
 * * @author Developer
 * @version 10.0
 */
public class TrainConsistManagementApp {

    // Bogie model representing a passenger bogie
    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    public static void main(String[] args) {
        System.out.println("=====================================================");
        System.out.println(" UC10 - Count Total Seats in Train ");
        System.out.println("=====================================================");

        // 1. Create a list of bogies
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper", 70));

        // Display bogies in the train
        System.out.println("Bogies in Train:");
        for (Bogie b : bogies) {
            System.out.println(b.name + " -> " + b.capacity);
        }

        // 2. Convert list to stream
        // 3. map() extracts capacity values
        // 4. reduce() sums the capacities
        int totalSeatingCapacity = bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        // 5. Total seating capacity is displayed
        System.out.println("\nTotal Seating Capacity of Train: " + totalSeatingCapacity);

        System.out.println("\nUC10 aggregation completed...");
    }
}