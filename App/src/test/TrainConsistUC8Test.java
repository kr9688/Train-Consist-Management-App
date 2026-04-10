import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistUC8Test {

    // Method under test: includes fail-fast validation + binary search
    private boolean searchBogie(String[] arr, String key) {

        // Fail-fast validation
        if (arr == null || arr.length == 0) {
            throw new IllegalStateException("No bogies available in the train.");
        }

        // Sort before binary search
        Arrays.sort(arr);

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;
            int cmp = arr[mid].compareTo(key);

            if (cmp == 0) {
                return true;
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }

    @Test
    void testSearch_ThrowsExceptionWhenEmpty() {
        String[] arr = {};

        assertThrows(IllegalStateException.class, () -> {
            searchBogie(arr, "BG101");
        });
    }

    @Test
    void testSearch_AllowsSearchWhenDataExists() {
        String[] arr = {"BG101","BG205"};

        assertDoesNotThrow(() -> {
            searchBogie(arr, "BG101");
        });
    }

    @Test
    void testSearch_BogieFoundAfterValidation() {
        String[] arr = {"BG101","BG205","BG309"};

        boolean result = searchBogie(arr, "BG205");

        assertTrue(result);
    }

    @Test
    void testSearch_BogieNotFoundAfterValidation() {
        String[] arr = {"BG101","BG205","BG309"};

        boolean result = searchBogie(arr, "BG999");

        assertFalse(result);
    }

    @Test
    void testSearch_SingleElementValidCase() {
        String[] arr = {"BG101"};

        boolean result = searchBogie(arr, "BG101");

        assertTrue(result);
    }
}