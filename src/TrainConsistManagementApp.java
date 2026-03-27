import java.util.ArrayList;
import java.util.List;

/**
 * UC12: Safety Compliance Check for Goods Bogies
 * Enforces domain safety rules using functional interfaces and lambda expressions[cite: 24].
 * * @author Developer
 * @version 12.0 [cite: 38, 39]
 */
public class TrainConsistManagementApp {

    // Goods Bogie model [cite: 42, 47]
    static class GoodsBogie {
        String type; // [cite: 50]
        String cargo; // [cite: 49]

        GoodsBogie(String type, String cargo) { // [cite: 51]
            this.type = type; // [cite: 52]
            this.cargo = cargo; // [cite: 53]
        }
    }

    public static void main(String[] args) {
        System.out.println("=====================================================");
        System.out.println(" UC12 Safety Compliance Check for Goods Bogies "); // [cite: 60]
        System.out.println("=====================================================");

        // 1. User prepares a list of goods bogies [cite: 67]
        List<GoodsBogie> goodsBogies = new ArrayList<>(); // [cite: 64]
        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum")); // [cite: 99]
        goodsBogies.add(new GoodsBogie("Open", "Coal")); // [cite: 100]
        goodsBogies.add(new GoodsBogie("Box", "Grain")); // [cite: 101]
        goodsBogies.add(new GoodsBogie("Cylindrical", "Coal")); // Invalid cargo [cite: 102]

        System.out.println("Goods Bogies in Train:"); // [cite: 98]
        for (GoodsBogie bogie : goodsBogies) {
            System.out.println(bogie.type + " -> " + bogie.cargo);
        }

        // 2. System converts the list into a stream [cite: 68]
        // 3. allMatch() checks every bogie against safety rules [cite: 69]
        // 4. Conditional logic verifies cylindrical bogie cargo [cite: 70]
        boolean isSafe = goodsBogies.stream().allMatch(bogie -> {
            // Rule: Cylindrical bogies are meant only for liquids like petroleum [cite: 12, 90]
            if (bogie.type.equalsIgnoreCase("Cylindrical")) {
                return bogie.cargo.equalsIgnoreCase("Petroleum");
            }
            // Non-cylindrical bogies (Open, Box) allow different cargo types [cite: 115, 116]
            return true;
        });

        // 5. If all checks pass, the train is marked safe [cite: 71]
        // 6. Result is displayed to the user [cite: 72]
        System.out.println("Safety Compliance Status: " + isSafe); // [cite: 103]

        if (isSafe) {
            System.out.println("Train formation is SAFE.");
        } else {
            System.out.println("Train formation is NOT SAFE."); // [cite: 104]
        }

        System.out.println("UC12 safety validation completed..."); // [cite: 105]
    }
}