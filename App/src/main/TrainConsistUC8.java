// Custom Runtime Exception
class CargoSafetyException extends RuntimeException {
    public CargoSafetyException(String message) {
        super(message);
    }
}

// Goods Bogie Class
class GoodsBogie {
    String shape;     // Rectangular or Cylindrical
    String cargoType; // e.g., Coal, Petroleum

    GoodsBogie(String shape) {
        this.shape = shape;
    }

    // Cargo assignment with safety handling
    public void assignCargo(String cargoType) {
        try {
            // Safety rule
            if (shape.equalsIgnoreCase("Rectangular") &&
                    cargoType.equalsIgnoreCase("Petroleum")) {

                throw new CargoSafetyException(
                        "Unsafe cargo: Petroleum cannot be assigned to Rectangular bogie"
                );
            }

            this.cargoType = cargoType;
            System.out.println("Cargo assigned successfully: " + cargoType);

        } catch (CargoSafetyException e) {
            System.out.println("Error: " + e.getMessage());

        } finally {
            System.out.println("Cargo assignment attempt completed for " + shape + " bogie");
        }
    }
}

// Main Application
public class TrainConsistUC8 {

    public static void main(String[] args) {

        GoodsBogie b1 = new GoodsBogie("Rectangular");
        GoodsBogie b2 = new GoodsBogie("Cylindrical");

        // Unsafe assignment
        b1.assignCargo("Petroleum");

        // Safe assignment
        b2.assignCargo("Petroleum");

        System.out.println("Program continues safely...");
    }
}