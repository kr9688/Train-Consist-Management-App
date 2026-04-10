import java.util.*;
import java.util.stream.Collectors;

// Bogie class
class Bogie {
    String name;
    int capacity;

    Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    String getName() {
        return name;
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

    // Method for grouping (helps in testing)
    public static Map<String, List<Bogie>> groupBogiesByType(List<Bogie> bogies) {
        return bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getName));
    }

    public static void main(String[] args) {

        // Step 1: Create bogie list
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("Sleeper", 70));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("AC Chair", 60));

        // Step 2–4: Stream → groupingBy → Map
        Map<String, List<Bogie>> grouped = groupBogiesByType(bogies);

        // Step 5: Display grouped result
        System.out.println("Grouped Bogies:");
        grouped.forEach((type, list) -> {
            System.out.println("\nType: " + type);
            list.forEach(System.out::println);
        });

        // Verify original list unchanged
        System.out.println("\nOriginal List:");
        bogies.forEach(System.out::println);
    }
}