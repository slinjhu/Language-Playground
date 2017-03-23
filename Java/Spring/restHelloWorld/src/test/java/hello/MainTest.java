package hello;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@WebAppConfiguration
public class MainTest {
    private MockMvc mockMvc;
    private final String name = "Sen";
    private Greeting mockGreeting;

    @Before
    public void setup(){
        mockGreeting = new Greeting(name);
    }

    @Test
    public void unitTest(){
        Controller controller = new Controller();
        assertEquals(mockGreeting, controller.sayHello1(name));
        assertEquals(mockGreeting, controller.sayHello2(name));
    }

    @Test
    public void integrationTest(){
        try {
            mockMvc.perform(get("/query?name=Sen"))
                    .andExpect(status().isOk());
            // TODO: check if the content is correct

            mockMvc.perform(get("/query"))
                    .andExpect(status().isOk());
            // TODO: check if the content is with name "World"

            mockMvc.perform(get("/path/Sen"))
                    .andExpect(status().isOk());
            // TODO: check if the content is with name "Sen"

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
