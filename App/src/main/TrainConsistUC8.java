import java.util.ArrayList;
import java.util.List;

// Reusing Bogie class
class Bogie {
    String name;
    int capacity;

    Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return name + " (" + capacity + ")";
    }
}

public class TrainConsistUC8 {

    // Method for aggregation (useful for testing)
    public static int calculateTotalCapacity(List<Bogie> bogies) {
        return bogies.stream()
                .map(b -> b.getCapacity())     // Extract capacities
                .reduce(0, Integer::sum);     // Aggregate (sum)
    }

    public static void main(String[] args) {

        // Step 1: Create bogie list
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper", 70));

        // Step 2–4: Stream → map → reduce
        int totalCapacity = calculateTotalCapacity(bogies);

        // Step 5: Display result
        System.out.println("Bogies:");
        bogies.forEach(System.out::println);

        System.out.println("\nTotal Seating Capacity: " + totalCapacity);
    }
}