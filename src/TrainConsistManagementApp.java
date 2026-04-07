import java.util.Arrays;
public class TrainConsistManagementApp  {
    public static void main(String[] args) {
        System.out.println("============================================");
        System.out.println(" UC19 - Binary Search for Bogie ID ");
        System.out.println("============================================\n");

        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        Arrays.sort(bogieIds);

        String key = "BG309";

        System.out.println("Sorted Bogie IDs:");
        for (String id : bogieIds) {
            System.out.println(id);
        }
        System.out.println();

        int resultIndex = performBinarySearch(bogieIds, key);

        if (resultIndex != -1) {
            System.out.println("Bogie " + key + " found using Binary Search.");
        } else {
            System.out.println("Bogie " + key + " not found.");
        }

        System.out.println("\nUC19 search completed.");
    }

    public static int performBinarySearch(String[] arr, String key) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comparison = key.compareTo(arr[mid]);

            if (comparison == 0) {
                return mid;
            } else if (comparison > 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
}