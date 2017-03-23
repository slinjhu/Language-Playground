package hello;

import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Main {
    public static void main(String[] args){
        SpringApplication.run(Main.class, args);
    }
}

@Data
class Greeting {
    private String name;
    private String message;

    public Greeting(String name){
        this.name = name;
        message = "Hello to " + this.name;
    }
}

@RestController
class Controller{
    /**
     * Pass information by query variables
     * @param name Name of the person to be greeted.
     * @return An object of type Greeting
     */
    @GetMapping("/query")
    public Greeting sayHello1(@RequestParam(value = "name", defaultValue = "World") String name){
        return new Greeting(name);
    }

    /**
     * Pass information by path variables
     * @param name Name of the person to be greeted.
     * @return An object of type Greeting
     */
    @GetMapping("/path/{name}")
    public Greeting sayHello2(@PathVariable("name") String name){
        return new Greeting(name);
    }
}