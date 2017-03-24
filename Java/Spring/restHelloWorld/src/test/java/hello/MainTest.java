package hello;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class MainTest {

  @Test
  public void unitTest() {
    final String me = "Sen";
    Greeting greetingMe = new Greeting(me);
    Controller controller = new Controller();

    assertEquals(greetingMe, controller.sayHello1(me));
    assertEquals(greetingMe, controller.sayHello2(me));
  }

}
