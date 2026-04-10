import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.regex.Pattern;

public class TrainConsistUC8Test {

    // Precompiled patterns (best practice)
    private static final Pattern TRAIN_PATTERN = Pattern.compile("TRN-\\d{4}");
    private static final Pattern CARGO_PATTERN = Pattern.compile("PET-[A-Z]{2}");

    private boolean isValidTrainId(String trainId) {
        return trainId != null && TRAIN_PATTERN.matcher(trainId).matches();
    }

    private boolean isValidCargoCode(String cargoCode) {
        return cargoCode != null && CARGO_PATTERN.matcher(cargoCode).matches();
    }

    @Test
    void testRegex_ValidTrainID() {
        assertTrue(isValidTrainId("TRN-1234"));
    }

    @Test
    void testRegex_InvalidTrainIDFormat() {
        assertFalse(isValidTrainId("TRAIN12"));
        assertFalse(isValidTrainId("TRN12A"));
        assertFalse(isValidTrainId("1234-TRN"));
    }

    @Test
    void testRegex_ValidCargoCode() {
        assertTrue(isValidCargoCode("PET-AB"));
    }

    @Test
    void testRegex_InvalidCargoCodeFormat() {
        assertFalse(isValidCargoCode("PET-ab"));   // lowercase
        assertFalse(isValidCargoCode("PET123"));   // missing hyphen
        assertFalse(isValidCargoCode("AB-PET"));   // wrong format
    }

    @Test
    void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(isValidTrainId("TRN-123"));    // less digits
        assertFalse(isValidTrainId("TRN-12345"));  // more digits
    }

    @Test
    void testRegex_CargoCodeUppercaseValidation() {
        assertFalse(isValidCargoCode("PET-Ab"));
        assertFalse(isValidCargoCode("PET-aB"));
    }

    @Test
    void testRegex_EmptyInputHandling() {
        assertFalse(isValidTrainId(""));
        assertFalse(isValidCargoCode(""));
    }

    @Test
    void testRegex_ExactPatternMatch() {
        assertFalse(isValidTrainId("TRN-1234X"));   // extra char
        assertFalse(isValidCargoCode("PET-ABC"));   // extra char
    }
}
