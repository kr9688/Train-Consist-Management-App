import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TrainConsistUC6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // HashMap to store bogie -> capacity
        Map<String, Integer> bogieCapacityMap = new HashMap<>();

        System.out.print("Enter number of bogies: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        // Input bogie and capacity
        for (int i = 0; i < n; i++) {
            System.out.print("Enter Bogie Name: ");
            String bogie = sc.nextLine();

            System.out.print("Enter Capacity: ");
            int capacity = sc.nextInt();
            sc.nextLine(); // consume newline

            // Insert into HashMap
            bogieCapacityMap.put(bogie, capacity);
        }

        // Display bogie-capacity mapping
        System.out.println("\nBogie Capacity Details:");
        for (Map.Entry<String, Integer> entry : bogieCapacityMap.entrySet()) {
            System.out.println("Bogie: " + entry.getKey() +
                    " -> Capacity: " + entry.getValue());
        }

        sc.close();
    }
}