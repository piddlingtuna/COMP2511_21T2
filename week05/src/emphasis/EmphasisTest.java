package emphasis;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class EmphasisTest {
    
    @Test
    public void testBasic() {
        Emphasis emphasis = new Emphasis();
        emphasis.setText("surely olliebot watches 100 times a day");
        emphasis.emphasis();

        assertEquals(emphasis.getText(), "SURELY OLLIEBOT WATCHES 100 TIMES A DAY!!!!");
    }

    @ParameterizedTest
    @ValueSource(strings = {"i don't think that's the same number of exclamation marks", "omg extra views", "UUID"})
    public void testIdempotency(String input) {
        Emphasis emphasis = new Emphasis();
        emphasis.setText(input);
        emphasis.emphasis();
        String emphasised = emphasis.getText();
        emphasis.emphasis();

        assertEquals(emphasis.getText(), emphasised);
    }
}
