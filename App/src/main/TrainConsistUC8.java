import java.util.ArrayList;
import java.util.List;

class GoodsBogie {
    String type;   // Rectangular / Cylindrical
    String cargo;  // Coal / Petroleum / etc.

    GoodsBogie(String type, String cargo) {
        this.type = type;
        this.cargo = cargo;
    }

    String getType() {
        return type;
    }

    String getCargo() {
        return cargo;
    }

    @Override
    public String toString() {
        return type + " -> " + cargo;
    }
}

public class TrainConsistUC8 {

    // Core validation logic
    public static boolean isSafetyCompliant(List<GoodsBogie> bogies) {
        return bogies.stream()
                .allMatch(b ->
                        // Rule: Cylindrical bogie must carry only Petroleum
                        !b.getType().equalsIgnoreCase("Cylindrical")
                                || b.getCargo().equalsIgnoreCase("Petroleum")
                );
    }

    public static void main(String[] args) {

        List<GoodsBogie> bogies = new ArrayList<>();

        bogies.add(new GoodsBogie("Rectangular", "Coal"));
        bogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        bogies.add(new GoodsBogie("Rectangular", "Grain"));

        // Perform safety check
        boolean isSafe = isSafetyCompliant(bogies);

        // Display bogies
        System.out.println("Goods Bogies:");
        bogies.forEach(System.out::println);

        // Result
        if (isSafe) {
            System.out.println("\nTrain is SAFETY COMPLIANT");
        } else {
            System.out.println("\nTrain is NOT SAFE");
        }
    }
}