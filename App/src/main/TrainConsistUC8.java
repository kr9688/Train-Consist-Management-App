import java.util.Arrays;
import java.util.Scanner;

public class TrainConsistUC8 {

    // Binary Search with fail-fast validation
    public static boolean searchBogie(String[] arr, String key) {

        // ✅ Fail-fast check
        if (arr == null || arr.length == 0) {
            throw new IllegalStateException("No bogies available in the train. Add bogies before searching.");
        }

        // Ensure sorted before binary search
        Arrays.sort(arr);

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;
            int cmp = arr[mid].compareTo(key);

            if (cmp == 0) {
                return true;
            }
            else if (cmp < 0) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of bogies: ");
        int n = sc.nextInt();
        sc.nextLine();

        String[] bogieIds = new String[n];

        if (n > 0) {
            System.out.println("Enter bogie IDs:");
            for (int i = 0; i < n; i++) {
                bogieIds[i] = sc.nextLine();
            }
        }

        System.out.print("Enter bogie ID to search: ");
        String key = sc.nextLine();

        try {
            boolean found = searchBogie(bogieIds, key);

            if (found) {
                System.out.println("Bogie found");
            } else {
                System.out.println("Bogie not found");
            }

        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Program continues...");
    }
}