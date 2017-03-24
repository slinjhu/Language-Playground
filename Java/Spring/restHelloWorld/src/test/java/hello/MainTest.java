package hello;

import lombok.SneakyThrows;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MainTest {
  @Autowired
  private MockMvc mockMvc;

  private final String me = "Sen";
  private Greeting greetingMe;
  private Greeting greetingWorld;


  @Before
  public void setup() {
    greetingMe = new Greeting(me);
    greetingWorld = new Greeting("World");
  }

  @Test
  public void unitTest() {
    Controller controller = new Controller();
    assertEquals(greetingMe, controller.sayHello1(me));
    assertEquals(greetingMe, controller.sayHello2(me));
  }

  @Test
  @SneakyThrows
  public void testLegalQuery() {
    mockMvc.perform(get(String.format("/query?name=%s", me)))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(jsonPath("$.name").value(greetingMe.getName()))
        .andExpect(jsonPath("$.message").value(greetingMe.getMessage()));
  }

  @Test
  @SneakyThrows
  public void testDefaultQuery() {
    mockMvc.perform(get("/query"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(jsonPath("$.name").value(greetingWorld.getName()))
        .andExpect(jsonPath("$.message").value(greetingWorld.getMessage()));
  }

  @Test
  @SneakyThrows
  public void testLegalPath() {
    mockMvc.perform(get(String.format("/path/%s", me)))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(jsonPath("$.name").value(greetingMe.getName()))
        .andExpect(jsonPath("$.message").value(greetingMe.getMessage()));
  }

  @Test
  @SneakyThrows
  public void testIllegalPath() {
    mockMvc.perform(get("/path"))
        .andExpect(status().is4xxClientError());
  }
}
