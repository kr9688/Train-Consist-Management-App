import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistUC8Test {

    // Reuse UC10 logic
    private int calculateTotalCapacity(List<Bogie> bogies) {
        return bogies.stream()
                .map(b -> b.getCapacity())
                .reduce(0, Integer::sum);
    }

    private List<Bogie> createSampleBogies() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper", 70));
        return bogies;
    }

    @Test
    void testReduce_TotalSeatCalculation() {
        int total = calculateTotalCapacity(createSampleBogies());
        assertEquals(222, total);
    }

    @Test
    void testReduce_MultipleBogiesAggregation() {
        List<Bogie> bogies = createSampleBogies();
        int total = calculateTotalCapacity(bogies);

        assertEquals(72 + 56 + 24 + 70, total);
    }

    @Test
    void testReduce_SingleBogieCapacity() {
        List<Bogie> bogies = List.of(new Bogie("Sleeper", 72));

        int total = calculateTotalCapacity(bogies);

        assertEquals(72, total);
    }

    @Test
    void testReduce_EmptyBogieList() {
        List<Bogie> bogies = new ArrayList<>();

        int total = calculateTotalCapacity(bogies);

        assertEquals(0, total);
    }

    @Test
    void testReduce_CorrectCapacityExtraction() {
        List<Bogie> bogies = createSampleBogies();

        List<Integer> capacities = bogies.stream()
                .map(b -> b.getCapacity())
                .toList();

        assertEquals(List.of(72, 56, 24, 70), capacities);
    }

    @Test
    void testReduce_AllBogiesIncluded() {
        List<Bogie> bogies = createSampleBogies();

        int total = calculateTotalCapacity(bogies);

        int expected = bogies.stream()
                .mapToInt(Bogie::getCapacity)
                .sum();

        assertEquals(expected, total);
    }

    @Test
    void testReduce_OriginalListUnchanged() {
        List<Bogie> bogies = createSampleBogies();
        int originalSize = bogies.size();

        calculateTotalCapacity(bogies);

        assertEquals(originalSize, bogies.size());
        assertEquals("Sleeper", bogies.get(0).name);
        assertEquals(72, bogies.get(0).capacity);
    }
}
