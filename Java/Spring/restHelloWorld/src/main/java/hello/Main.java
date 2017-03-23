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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Greeting greeting = (Greeting) o;

        if (name != null ? !name.equals(greeting.name) : greeting.name != null) return false;
        return message != null ? message.equals(greeting.message) : greeting.message == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (message != null ? message.hashCode() : 0);
        return result;
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