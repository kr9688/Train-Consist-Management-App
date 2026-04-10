import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Scanner;

public class TrainConsistUC5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // LinkedHashSet preserves insertion order + prevents duplicates
        Set<String> formation = new LinkedHashSet<>();

        System.out.print("Enter number of bogies to attach: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        // Input bogies
        for (int i = 0; i < n; i++) {
            System.out.print("Enter Bogie Name: ");
            String bogie = sc.nextLine();

            if (formation.add(bogie)) {
                System.out.println(bogie + " attached successfully.");
            } else {
                System.out.println("Duplicate bogie! " + bogie + " ignored.");
            }
        }

        // Display final formation (in insertion order)
        System.out.println("\nFinal Train Formation (Insertion Order Preserved):");
        for (String b : formation) {
            System.out.println(b);
        }

        sc.close();
    }
}