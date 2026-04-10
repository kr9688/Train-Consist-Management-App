import java.util.Arrays;
import java.util.Scanner;

public class  TrainConsistUC8{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of bogie types: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        String[] bogieTypes = new String[n];

        System.out.println("Enter bogie type names:");
        for (int i = 0; i < n; i++) {
            bogieTypes[i] = sc.nextLine();
        }

        System.out.println("Before Sorting: " + Arrays.toString(bogieTypes));

        // Built-in sorting
        Arrays.sort(bogieTypes);

        System.out.println("After Sorting: " + Arrays.toString(bogieTypes));

        System.out.println("Program continues...");
    }
}