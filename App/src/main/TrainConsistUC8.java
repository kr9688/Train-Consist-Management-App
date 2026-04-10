import java.util.Scanner;

public class TrainConsistUC8 {

    // Linear Search Method
    public static int linearSearch(String[] bogieIds, String key) {

        for (int i = 0; i < bogieIds.length; i++) {

            // Compare using equals()
            if (bogieIds[i].equals(key)) {
                return i; // Found → return index
            }
        }

        return -1; // Not found
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of bogies: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        String[] bogieIds = new String[n];

        System.out.println("Enter bogie IDs:");
        for (int i = 0; i < n; i++) {
            bogieIds[i] = sc.nextLine();
        }

        System.out.print("Enter bogie ID to search: ");
        String key = sc.nextLine();

        int result = linearSearch(bogieIds, key);

        if (result != -1) {
            System.out.println("Bogie found at position: " + result);
        } else {
            System.out.println("Bogie not found");
        }

        System.out.println("Program continues...");
    }
}