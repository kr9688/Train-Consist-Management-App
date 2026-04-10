import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

public class TrainConsistUC8Test {

    @Test
    void testSort_BasicAlphabeticalSorting() {
        String[] input = {"Sleeper","AC Chair","First Class","General","Luxury"};
        String[] expected = {"AC Chair","First Class","General","Luxury","Sleeper"};

        Arrays.sort(input);

        assertArrayEquals(expected, input);
    }

    @Test
    void testSort_UnsortedInput() {
        String[] input = {"Luxury","General","Sleeper","AC Chair"};
        String[] expected = {"AC Chair","General","Luxury","Sleeper"};

        Arrays.sort(input);

        assertArrayEquals(expected, input);
    }

    @Test
    void testSort_AlreadySortedArray() {
        String[] input = {"AC Chair","First Class","General"};
        String[] expected = {"AC Chair","First Class","General"};

        Arrays.sort(input);

        assertArrayEquals(expected, input);
    }

    @Test
    void testSort_DuplicateBogieNames() {
        String[] input = {"Sleeper","AC Chair","Sleeper","General"};
        String[] expected = {"AC Chair","General","Sleeper","Sleeper"};

        Arrays.sort(input);

        assertArrayEquals(expected, input);
    }

    @Test
    void testSort_SingleElementArray() {
        String[] input = {"Sleeper"};
        String[] expected = {"Sleeper"};

        Arrays.sort(input);

        assertArrayEquals(expected, input);
    }
}