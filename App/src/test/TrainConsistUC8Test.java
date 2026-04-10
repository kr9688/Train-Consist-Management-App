import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistUC8Test {

    // Linear Search returning boolean
    private boolean linearSearch(String[] arr, String key) {
        for (String id : arr) {
            if (id.equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Test
    void testSearch_BogieFound() {
        String[] arr = {"BG101","BG205","BG309","BG412","BG550"};

        boolean result = linearSearch(arr, "BG309");

        assertTrue(result);
    }

    @Test
    void testSearch_BogieNotFound() {
        String[] arr = {"BG101","BG205","BG309","BG412","BG550"};

        boolean result = linearSearch(arr, "BG999");

        assertFalse(result);
    }

    @Test
    void testSearch_FirstElementMatch() {
        String[] arr = {"BG101","BG205","BG309","BG412","BG550"};

        boolean result = linearSearch(arr, "BG101");

        assertTrue(result);
    }

    @Test
    void testSearch_LastElementMatch() {
        String[] arr = {"BG101","BG205","BG309","BG412","BG550"};

        boolean result = linearSearch(arr, "BG550");

        assertTrue(result);
    }

    @Test
    void testSearch_SingleElementArray() {
        String[] arr = {"BG101"};

        boolean result = linearSearch(arr, "BG101");

        assertTrue(result);
    }
}