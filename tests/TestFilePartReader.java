import com.codecool.FilePartReader;
import org.junit.jupiter.api.*;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestFilePartReader {
    private FilePartReader reader;

    @Test
    @BeforeEach
    @DisplayName("Initializing a new FilePartReader object before every testcase.")
    public void initializeFilePartReaderObject() {
        reader = new FilePartReader();
    }

    @Test
    @DisplayName("Given created a new instance " +
            "When we call for it " +
            "Then it doesn't return null")
    public void canBeInitialized() {
        assertNotNull(reader);
    }

    @Test
    @DisplayName("Given created a new instance and call its method, setup(something, 1, 1) " +
            "When we call the getter of the instance variables " +
            "Then the result should be 'something', 1, 1")
    public void canInstanceVariablesBeChanged() {
        reader.setup("resources/sample.txt", 1, 1);
        assertEquals("resources/sample.txt", reader.getFilePath());
        assertEquals(1, reader.getFromLine());
        assertEquals(1, reader.getToLine());
    }

    @Test
    @DisplayName("Given created a new instance and call its method, setup() " +
            "When we call the getter of the variable fromLine " +
            "Then the results shouldn't be null")
    public void isFromLineNotNull() {
        reader.setup("resources/sample.txt", 1, 1);
        assertNotNull(reader.getFromLine());
    }

    @Test
    @DisplayName("Given created a new instance " +
            "When we call its method, setup(something, 2, 1) " +
            "Then it should raise IllegalArgumentException")
    public void CanFromLineBeGreaterThanToLine() {
        assertThrows(IllegalArgumentException.class, ()-> {
                reader.setup("something", 2, 1);
        });
    }

    @Test
    @DisplayName("Given created a new instance and call its method, setup() " +
            "When we call the getter of the variable filePath " +
            "Then the results shouldn't be null")
    public void isToLineNotNull() {
        reader.setup("resources/sample.txt", 1, 1);
        assertNotNull(reader.getToLine());
    }

    @Test
    @DisplayName("Given creating a new instance and we setup one line to read " +
            "When we call its method, readLines() " +
            "Then the results shouldn't be null")
    public void isReadLinesNotNull() throws IOException {
        reader.setup("resources/sample.txt", 1, 1);
        assertNotNull(reader.readLines());
    }

    @Test
    @DisplayName("Given created a new instance and we setup the first line to read" +
            "When we call its method, readLines() " +
            "Then the results should be 'lol'")
    public void canReadLinesReturnTheFirst() throws IOException {
        reader.setup("resources/sample.txt", 1, 1);
        String firstLine = reader.readLines();
        assertEquals("lol", firstLine);
    }

    @Test
    @DisplayName("Given created a new instance and we setup one line to read" +
            "When we call its method, readLines() " +
            "Then the results should be 'lol'")
    public void canReadLinesReturnMultipleLines() throws IOException {
        reader.setup("resources/sample.txt", 1, 2);
        String lines = reader.readLines();
        assertEquals("lol alma a fa alatt", lines);

        reader.setup("resources/sample.txt", 1, 8);
        lines = reader.readLines();
        assertEquals(
                "lol alma a fa alatt kayak sos nyári piros sorip alma alma amla level radar",
                lines
        );

        reader.setup("resources/sample.txt", 6, 8);
        lines = reader.readLines();
        assertEquals("alma amla level radar", lines);

        reader.setup("resources/sample.txt", 3, 5);
        lines = reader.readLines();
        assertEquals("kayak sos nyári piros sorip alma", lines);
    }

    @Test
    @DisplayName("Given created a new instance" +
            "When we call its method, read() " +
            "Then the results should be " +
            "'lol alma a fa alatt kayak sos nyári piros sorip alma alma amla level radar'")
    public void isReadWorking() throws IOException {
        reader.setup("resources/sample.txt", 1, 1);
        String lines = reader.read();
        assertEquals(
                "lol alma a fa alatt kayak sos nyári piros sorip alma alma amla level radar",
                lines
        );
    }
}
