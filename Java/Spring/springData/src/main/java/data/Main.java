package data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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
    private int year;
}


@Repository
interface BookRepository extends CrudRepository<Book, Long> {
    Book findById(long id);
    Iterable<Book> findByAuthor(String author);
    Iterable<Book> findByAuthorAndYear(String author, int year);
}

@RestController
class Controller {
    @Autowired
    private BookRepository _repository;

    @GetMapping("/id/{id}")
    public Book findBookById(@PathVariable("id") long id){
        return _repository.findById(id);
    }

    @GetMapping("/author/{author}")
    public Iterable<Book> findBookByAuthor(@PathVariable("author") String author){
        return _repository.findByAuthor(author);
    }

    @GetMapping("/find")
    public Iterable<Book> findBookByAuthorAndYear(
        @RequestParam("author") String author,
        @RequestParam("year") int year
    ){
        return _repository.findByAuthorAndYear(author, year);
    }

    @GetMapping("/allbooks")
    public Iterable<Book> allBooks(){
        return _repository.findAll();
    }
}