import java.util.Arrays;
import java.util.Scanner;

public class TrainConsistUC8 {

    // Binary Search Method
    public static int binarySearch(String[] arr, String key) {

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            int cmp = arr[mid].compareTo(key);

            if (cmp == 0) {
                return mid; // Found
            }
            else if (cmp < 0) {
                low = mid + 1; // Search right half
            }
            else {
                high = mid - 1; // Search left half
            }
        }

        return -1; // Not found
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of bogies: ");
        int n = sc.nextInt();
        sc.nextLine();

        String[] bogieIds = new String[n];

        System.out.println("Enter bogie IDs:");
        for (int i = 0; i < n; i++) {
            bogieIds[i] = sc.nextLine();
        }

        // Ensure sorted (precondition)
        Arrays.sort(bogieIds);

        System.out.println("Sorted Bogie IDs: " + Arrays.toString(bogieIds));

        System.out.print("Enter bogie ID to search: ");
        String key = sc.nextLine();

        int result = binarySearch(bogieIds, key);

        if (result != -1) {
            System.out.println("Bogie found at position: " + result);
        } else {
            System.out.println("Bogie not found");
        }

        System.out.println("Program continues...");
    }
}