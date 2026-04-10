import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistUC8Test {

    // Loop-based filtering
    private List<Bogie> filterWithLoop(List<Bogie> bogies) {
        List<Bogie> result = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.getCapacity() > 60) {
                result.add(b);
            }
        }
        return result;
    }

    // Stream-based filtering
    private List<Bogie> filterWithStream(List<Bogie> bogies) {
        return bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());
    }

    // Sample data
    private List<Bogie> createSampleBogies() {
        return List.of(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56),
                new Bogie("First Class", 80),
                new Bogie("Sleeper", 60)
        );
    }

    @Test
    void testLoopFilteringLogic() {
        List<Bogie> result = filterWithLoop(createSampleBogies());

        assertEquals(2, result.size());
        assertTrue(result.stream().allMatch(b -> b.getCapacity() > 60));
    }

    @Test
    void testStreamFilteringLogic() {
        List<Bogie> result = filterWithStream(createSampleBogies());

        assertEquals(2, result.size());
        assertTrue(result.stream().allMatch(b -> b.getCapacity() > 60));
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        List<Bogie> bogies = createSampleBogies();

        List<Bogie> loopResult = filterWithLoop(bogies);
        List<Bogie> streamResult = filterWithStream(bogies);

        assertEquals(loopResult.size(), streamResult.size());
    }

    @Test
    void testExecutionTimeMeasurement() {
        List<Bogie> bogies = createSampleBogies();

        long start = System.nanoTime();
        filterWithStream(bogies);
        long end = System.nanoTime();

        long elapsed = end - start;

        assertTrue(elapsed > 0);
    }

    @Test
    void testLargeDatasetProcessing() {
        List<Bogie> largeList = new ArrayList<>();

        for (int i = 0; i < 100000; i++) {
            largeList.add(new Bogie("Sleeper", 50 + (i % 50)));
        }

        List<Bogie> result = filterWithStream(largeList);

        assertNotNull(result);
        assertTrue(result.stream().allMatch(b -> b.getCapacity() > 60));
    }
}