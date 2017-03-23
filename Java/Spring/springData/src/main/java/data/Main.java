package data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import lombok.Data;
import javax.persistence.*;


@SpringBootApplication
public class Main {
    public static void main(String[] args){
        SpringApplication.run(Main.class, args);
    }
}

@Entity
@Data
@Table(name = "book")
class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "title")
    private String title;

    private String author;
}


@Repository
interface BookRepository extends CrudRepository<Book, Long> {
    Book findById(long id);
}

@RestController
class Controller {
    @Autowired
    private BookRepository _repository;

    @GetMapping("/book/{id}")
    public Book findBook(@PathVariable("id") long id){
        return _repository.findById(id);
    }

    @GetMapping("/allbooks")
    public Iterable<Book> allBooks(){
        return _repository.findAll();
    }
}