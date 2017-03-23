package hello;

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


class Greeting {
    private String name;
    private String message;

    public Greeting(String name){
        this.name = name;
        message = "Hello to " + this.name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

@RestController
class Controller{
    @GetMapping("/query")
    public Greeting sayHello1(@RequestParam(value = "name", defaultValue = "Sen") String name){
        return new Greeting(name);
    }

    @GetMapping("/path/{name}")
    public Greeting sayHello2(@PathVariable("name") String name){
        return new Greeting(name);
    }
}