import java.util.*;
import java.util.stream.Collectors;

class Bogie {
    String type;
    int capacity;

    Bogie(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
    }

    String getType() {
        return type;
    }

    int getCapacity() {
        return capacity;
    }
}

public class TrainConsistUC8 {

    public static void main(String[] args) {

        // Step 1: Prepare large dataset
        List<Bogie> bogies = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            bogies.add(new Bogie(i % 2 == 0 ? "Sleeper" : "AC Chair", 50 + (i % 20)));
        }

        // ---------------- LOOP APPROACH ----------------
        long startLoop = System.nanoTime();

        List<Bogie> loopResult = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.getType().equals("Sleeper")) {
                loopResult.add(b);
            }
        }

        long endLoop = System.nanoTime();
        long loopTime = endLoop - startLoop;

        // ---------------- STREAM APPROACH ----------------
        long startStream = System.nanoTime();

        List<Bogie> streamResult = bogies.stream()
                .filter(b -> b.getType().equals("Sleeper"))
                .collect(Collectors.toList());

        long endStream = System.nanoTime();
        long streamTime = endStream - startStream;

        // ---------------- OUTPUT ----------------
        System.out.println("Loop Result Size: " + loopResult.size());
        System.out.println("Stream Result Size: " + streamResult.size());

        System.out.println("\nExecution Time:");
        System.out.println("Loop Time   : " + loopTime + " ns");
        System.out.println("Stream Time : " + streamTime + " ns");

        // Comparison insight
        if (loopTime < streamTime) {
            System.out.println("\nLoop is faster in this run.");
        } else {
            System.out.println("\nStream is faster in this run.");
        }
    }
}