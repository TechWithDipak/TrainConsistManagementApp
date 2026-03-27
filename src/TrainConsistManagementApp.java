import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Use Case 11: Validate Train ID and Cargo Code
 * This class validates input formats using Regular Expressions.
 * * @author Developer
 * @version 11.0
 */
public class TrainConsistManagementApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=====================================================");
        System.out.println(" UC11 - Validate Train ID and Cargo Code ");
        System.out.println("=====================================================");

        // Accept input from the user [cite: 184, 185]
        System.out.print("Enter Train ID (Format: TRN-1234): ");
        String trainId = scanner.nextLine();

        System.out.print("Enter Cargo Code (Format: PET-AB): ");
        String cargoCode = scanner.nextLine();

        // DEFINE REGEX RULES [cite: 204, 221, 222]
        // TRN- followed by exactly 4 digits
        String trainIdRegex = "TRN-\\d{4}";
        // PET- followed by exactly 2 uppercase letters
        String cargoCodeRegex = "PET-[A-Z]{2}";

        // Apply regex validation using Pattern and Matcher [cite: 186, 208, 209]
        Pattern trainIdPattern = Pattern.compile(trainIdRegex);
        Matcher trainIdMatcher = trainIdPattern.matcher(trainId);

        Pattern cargoCodePattern = Pattern.compile(cargoCodeRegex);
        Matcher cargoCodeMatcher = cargoCodePattern.matcher(cargoCode);

        // Validate using matches() for exact pattern matching [cite: 217, 224]
        boolean isTrainIdValid = trainIdMatcher.matches();
        boolean isCargoCodeValid = cargoCodeMatcher.matches();

        // Display validation results [cite: 187, 225]
        System.out.println("\nValidation Results:");
        System.out.println("Train ID Valid: " + isTrainIdValid);
        System.out.println("Cargo Code Valid: " + isCargoCodeValid);

        System.out.println("\nUC11 validation completed...");

        scanner.close();
    }
}