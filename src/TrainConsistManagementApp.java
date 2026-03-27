import java.util.*;
import java.util.stream.Collectors;

public class TrainConsistManagementApp {

    // Bogie model
    static class Bogie {
        String type;
        int capacity;

        Bogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return type + " (Capacity: " + capacity + ")";
        }
    }

    public static void main(String[] args) {
        System.out.println(" =============================================== ");
        System.out.println(" UC13 - Performance Comparison (Loops vs Streams) ");
        System.out.println(" =============================================== \n");

        // Create large test dataset
        List<Bogie> bogies = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            bogies.add(new Bogie("Passenger-" + i, (i % 100) + 1));
        }

        // Loop-based filtering
        long startLoop = System.nanoTime();
        List<Bogie> loopFiltered = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.capacity > 60) {
                loopFiltered.add(b);
            }
        }
        long endLoop = System.nanoTime();
        long loopDuration = endLoop - startLoop;

        // Stream-based filtering
        long startStream = System.nanoTime();
        List<Bogie> streamFiltered = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
        long endStream = System.nanoTime();
        long streamDuration = endStream - startStream;

        // Display results
        System.out.println("Loop Execution Time (ns): " + loopDuration);
        System.out.println("Stream Execution Time (ns): " + streamDuration);
        System.out.println("UC13 performance benchmarking completed ...");

        // Consistency check
        if (loopFiltered.size() == streamFiltered.size()) {
            System.out.println("Both approaches produced identical results.");
        } else {
            System.out.println("Mismatch detected between loop and stream results!");
        }
    }
}