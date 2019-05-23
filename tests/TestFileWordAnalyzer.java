import com.codecool.FilePartReader;
import com.codecool.FileWordAnalyzer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestFileWordAnalyzer {
    private FilePartReader filePartReader;
    private FileWordAnalyzer fileWordAnalyzer;

    @Test
    @BeforeEach
    @DisplayName("Initializing a new FileWordAnalyzer object before every testcase.")
    public void initializeFileWordAnalyzer() {
        filePartReader = new FilePartReader();
        fileWordAnalyzer = new FileWordAnalyzer(filePartReader);
        assertNotNull(fileWordAnalyzer);
    }

    @Test
    @DisplayName("Given created a new instance and " +
            "called FilePartReader.setup('resources/sample.txt', 1, 3) " +
            "When we call method getWordsOrderedAlphabetically() " +
            "Then the result should be a List containing: " +
            "'a', 'alatt', 'alma', 'kayak', 'lol', 'fa', 'sos'")
    public void getWordsOrderedAlphabetically() throws IOException {
        filePartReader.setup("resources/sample.txt", 1, 3);
        List expected = new ArrayList<>(
                List.of(
                        "a",
                        "alatt",
                        "alma",
                        "fa",
                        "kayak",
                        "lol",
                        "sos"
                ));
        assertEquals(expected, fileWordAnalyzer.getWordsOrderedAlphabetically());
    }

    @Test
    @DisplayName("Given created a new instance and " +
            "called FilePartReader.setup('resources/sample.txt', 1, 3) " +
            "When we call method getWordsContainingSubstring('al') " +
            "Then the result should be a List containing: " +
            "'alma', 'alatt' in any order")
    public void getWordsContainingSubstring() throws IOException {
        filePartReader.setup("resources/sample.txt", 1, 3);
        List expected = new ArrayList<>(
                List.of(
                        "alma",
                        "alatt"
                ));
        assert(expected.containsAll(fileWordAnalyzer.getWordsContainingSubstring("al")));
    }

    @Test
    @DisplayName("Given created a new instance and " +
            "called FilePartReader.setup('resources/sample.txt', 1, 3) " +
            "When we call method getStringsWhichPalindromes() " +
            "Then the result should be a List containing: " +
            "'lol', 'a', 'kayak', 'sos' in any order")
    public void getStringsWhichPalindromes() throws IOException {
        filePartReader.setup("resources/sample.txt", 1, 3);
        List expected = new ArrayList<>(
                List.of(
                        "lol",
                        "a",
                        "kayak",
                        "sos"
                ));
        assert(expected.containsAll(fileWordAnalyzer.getStringsWhichPalindromes()));
    }

}
