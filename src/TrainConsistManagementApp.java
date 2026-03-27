import java.util.*;

// Step 1: Create Bogie class
class Bogie {
    String name;
    int capacity;

    // Constructor
    Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    // Display method
    void display() {
        System.out.println(name + " -> " + capacity);
    }
}

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("=====================================");
        System.out.println("UC7 - Sort Bogies by Capacity (Comparator)");
        System.out.println("=====================================");

        // Step 2: Create List
        List<Bogie> bogieList = new ArrayList<>();

        // Step 3: Add Bogies
        bogieList.add(new Bogie("Sleeper", 72));
        bogieList.add(new Bogie("AC Chair", 56));
        bogieList.add(new Bogie("First Class", 24));
        bogieList.add(new Bogie("General", 90));

        // Before Sorting
        System.out.println("\nBefore Sorting:");
        for (Bogie b : bogieList) {
            b.display();
        }

        // Step 4: Sort using Comparator (by capacity)
        bogieList.sort(Comparator.comparingInt(b -> b.capacity));

        // After Sorting
        System.out.println("\nAfter Sorting by Capacity:");
        for (Bogie b : bogieList) {
            b.display();
        }

        System.out.println("\nUC7 sorting completed...");
    }
}