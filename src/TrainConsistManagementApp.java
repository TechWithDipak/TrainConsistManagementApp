/**
 * Custom Exception to handle invalid bogie capacity.
 */
class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

/**
 * Use Case 14: Handle Invalid Bogie Capacity (Custom Exception)
 * This class prevents invalid passenger bogies from being added to the train
 * by enforcing capacity rules at the time of object creation.
 * * @author Developer
 * @version 14.0
 */
public class TrainConsistManagementApp {

    // Passenger Bogie model with validation logic
    static class PassengerBogie {
        String type;
        int capacity;

        /**
         * Constructor that enforces safety rules.
         * @throws InvalidCapacityException if capacity is less than or equal to zero.
         */
        PassengerBogie(String type, int capacity) throws InvalidCapacityException {
            if (capacity <= 0) {
                // Rule: Capacity must be greater than zero
                throw new InvalidCapacityException("Capacity must be greater than zero");
            }
            this.type = type;
            this.capacity = capacity;
        }
    }

    public static void main(String[] args) {
        System.out.println("=====================================================");
        System.out.println(" UC14 - Handle Invalid Bogie Capacity ");
        System.out.println("=====================================================");

        try {
            // Attempting to create a valid bogie
            System.out.println("Creating Sleeper bogie with 72 seats...");
            PassengerBogie validBogie = new PassengerBogie("Sleeper", 72);
            System.out.println("Successfully created: " + validBogie.type);

            // Attempting to create an invalid bogie (Zero Capacity)
            System.out.println("\nCreating AC Chair bogie with 0 seats...");
            PassengerBogie invalidBogie = new PassengerBogie("AC Chair", 0);

        } catch (InvalidCapacityException e) {
            // Catching and displaying the custom error message
            System.err.println("Error: " + e.getMessage());
        }

        try {
            // Attempting to create an invalid bogie (Negative Capacity)
            System.out.println("\nCreating First Class bogie with -10 seats...");
            PassengerBogie negativeBogie = new PassengerBogie("First Class", -10);

        } catch (InvalidCapacityException e) {
            System.err.println("Error: " + e.getMessage());
        }

        System.out.println("\nUC14 exception handling completed...");
    }
}