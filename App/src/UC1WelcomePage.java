import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// Bogie class (custom object)
class Bogie {
    String name;
    int capacity;

    // Constructor
    Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    // Display method
    void display() {
        System.out.println("Bogie: " + name + " -> Capacity: " + capacity);
    }
}

public class TrainConsistUC7 {
    public static void main(String[] args) {

        // List to store bogie objects
        List<Bogie> bogies = new ArrayList<>();

        // Adding passenger bogies
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));

        // Sorting using Comparator (by capacity)
        bogies.sort(Comparator.comparingInt(b -> b.capacity));

        // Display sorted bogies
        System.out.println("Bogies Sorted by Capacity (Ascending):");
        for (Bogie b : bogies) {
            b.display();
        }
    }
}