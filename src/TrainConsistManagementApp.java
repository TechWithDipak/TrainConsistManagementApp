import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Use Case 13: Performance Comparison (Loops vs Streams)
 * Benchmarks the execution time of traditional loops against Stream API
 * using System.nanoTime() for a large dataset of bogies.
 * * @author Developer
 * @version 13.0
 */
public class TrainConsistManagementApp {

    static class PassengerBogie {
        String type;
        int capacity;

        PassengerBogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }
    }

    public static void main(String[] args) {
        System.out.println("=====================================================");
        System.out.println(" UC13 - Performance Comparison (Loops vs Streams) ");
        System.out.println("=====================================================");

        // 1. Prepare a large dataset (e.g., 10,000 bogies)
        List<PassengerBogie> bogieList = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            bogieList.add(new PassengerBogie("Sleeper", 72));
            bogieList.add(new PassengerBogie("AC Chair", 56));
        }

        // --- LOOP PERFORMANCE MEASUREMENT ---
        long startLoop = System.nanoTime(); // Start timestamp
        List<PassengerBogie> loopFiltered = new ArrayList<>();
        for (PassengerBogie b : bogieList) {
            if (b.capacity > 60) {
                loopFiltered.add(b);
            }
        }
        long endLoop = System.nanoTime(); // End timestamp
        long loopDuration = endLoop - startLoop;

        // --- STREAM PERFORMANCE MEASUREMENT ---
        long startStream = System.nanoTime(); // Start timestamp
        List<PassengerBogie> streamFiltered = bogieList.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
        long endStream = System.nanoTime(); // End timestamp
        long streamDuration = endStream - startStream;

        // 2. Display results and performance metrics
        System.out.println("Total Bogies Processed: " + bogieList.size());
        System.out.println("Filtered Count (Loop): " + loopFiltered.size());
        System.out.println("Filtered Count (Stream): " + streamFiltered.size());

        System.out.println("\nExecution Time Results:");
        System.out.println("Traditional Loop Time: " + loopDuration + " ns");
        System.out.println("Stream API Time      : " + streamDuration + " ns");

        // 3. Performance Analysis
        if (loopDuration < streamDuration) {
            System.out.println("\nResult: Traditional Loop was faster in this run.");
        } else {
            System.out.println("\nResult: Stream API was faster in this run.");
        }

        System.out.println("\nUC13 performance comparison completed...");
    }
}