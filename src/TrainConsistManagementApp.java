import java.util.LinkedList;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("=======================================");
        System.out.println("UC4 - Maintain Ordered Bogie Consist");
        System.out.println("=======================================\n");

        // Create LinkedList
        LinkedList<String> train = new LinkedList<>();

        // Initial bogies
        train.add("Engine");
        train.add("Sleeper");
        train.add("AC");
        train.add("Cargo");
        train.add("Guard");

        // Initial state
        System.out.println("Initial Train Consist:");
        System.out.println(train + "\n");

        // Insert Pantry Car at position 2
        train.add(2, "Pantry Car");

        System.out.println("After Inserting 'Pantry Car' at position 2:");
        System.out.println(train + "\n");

        // Remove first and last
        train.removeFirst();
        train.removeLast();

        System.out.println("After Removing First and Last Bogie:");
        System.out.println(train + "\n");

        System.out.println("UC4 ordered consist operations completed...");
    }
}