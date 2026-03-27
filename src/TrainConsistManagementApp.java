public class TrainConsistManagementApp {

    // ---- CUSTOM EXCEPTION ----
    static class InvalidCapacityException extends Exception {
        public InvalidCapacityException(String message) {
            super(message);
        }
    }

    // ---- Passenger Bogie Model ----
    static class PassengerBogie {
        private String type;
        private int capacity;

        // Constructor with validation
        public PassengerBogie(String type, int capacity) throws InvalidCapacityException {
            if (capacity <= 0) {
                throw new InvalidCapacityException("Capacity must be greater than zero");
            }
            this.type = type;
            this.capacity = capacity;
        }

        // Getters
        public String getType() {
            return type;
        }

        public int getCapacity() {
            return capacity;
        }

        @Override
        public String toString() {
            return "PassengerBogie{" +
                    "type='" + type + '\'' +
                    ", capacity=" + capacity +
                    '}';
        }
    }

    // ---- MAIN METHOD ----
    public static void main(String[] args) {
        try {
            PassengerBogie bogie1 = new PassengerBogie("Sleeper", 72);
            System.out.println("Created: " + bogie1);

            PassengerBogie bogie2 = new PassengerBogie("AC Chair", 0); // will throw exception
            System.out.println("Created: " + bogie2);

        } catch (InvalidCapacityException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        System.out.println("Execution continues safely...");
    }
}