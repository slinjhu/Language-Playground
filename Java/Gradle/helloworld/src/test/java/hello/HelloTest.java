package hello;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class HelloTest{
    @Test
    public void testSay(){
        assertEquals("Hello world", Hello.say());
    }
}
