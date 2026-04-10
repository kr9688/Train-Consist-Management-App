import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TrainConsistUC3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create HashSet to store unique bogie IDs
        Set<String> bogieIds = new HashSet<>();

        System.out.print("Enter number of bogies to add: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        // Input bogie IDs
        for (int i = 0; i < n; i++) {
            System.out.print("Enter Bogie ID: ");
            String id = sc.nextLine();

            // Add to HashSet
            if (bogieIds.add(id)) {
                System.out.println("Bogie " + id + " added successfully.");
            } else {
                System.out.println("Duplicate ID! Bogie " + id + " ignored.");
            }
        }

        // Display unique bogie IDs
        System.out.println("\nFinal Unique Bogie IDs:");
        for (String id : bogieIds) {
            System.out.println(id);
        }

        sc.close();
    }
}