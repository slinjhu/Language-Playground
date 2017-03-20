package hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller {
  @GetMapping("/greeting")
  public Greeting sendGreeting(
      @RequestParam(value = "name", defaultValue = "World") String name
  ){
    Greeting greeting = new Greeting();
    greeting.setName(name);
    return greeting;
  }
}
