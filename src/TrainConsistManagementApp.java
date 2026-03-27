import java.util.*;
import java.util.stream.*;

class Bogie {
    private String type;
    private int capacity;

    public Bogie(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }
}
public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("===========================================");
        System.out.println("   UC9 - Group Bogies by Type");
        System.out.println("===========================================\n");


        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper", 70));
        bogies.add(new Bogie("AC Chair", 60));


        System.out.println("All Bogies:");
        bogies.forEach(b ->
                System.out.println(b.getType() + " -> " + b.getCapacity())
        );


        Map<String, List<Bogie>> groupedBogies = bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getType));


        System.out.println("\nGrouped Bogies:\n");

        groupedBogies.forEach((type, list) -> {
            System.out.println("Bogie Type: " + type);
            list.forEach(b ->
                    System.out.println("Capacity -> " + b.getCapacity())
            );
            System.out.println();
        });

        System.out.println("UC9 grouping completed...");
    }
}