package hello;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class HelloIntest{
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setupStream() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStream() {
        System.setOut(null);
    }

    @Test
    public void testOutput(){
        Hello.main(null);
        assertEquals("Hello world\n", outContent.toString());
    }
}
