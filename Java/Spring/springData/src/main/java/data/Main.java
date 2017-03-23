package data;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
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
@NoArgsConstructor
@AllArgsConstructor
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

    /**
     * Find a book by author and year.
     * @param author The target author provided using a request parameter
     * @param year The target year provided using a request parameter
     * @return
     */
    @GetMapping("/find")
    public Iterable<Book> findBookByAuthorAndYear(
        @RequestParam("author") String author,
        @RequestParam("year") int year
    ){
        return _repository.findByAuthorAndYear(author, year);
    }

    /**
     * Find all books in the database
     * @return all books as a JSON list
     */
    @GetMapping("/allbooks")
    public Iterable<Book> allBooks(){
        return _repository.findAll();
    }

    /**
     * Delete all books with the given author
     * @param author provided using path variable
     * @return All books after deletion.
     */

    @GetMapping("/deleteauthor/{author}")
    public Iterable<Book> deleteByAuthor(@PathVariable("author") String author){
        _repository.delete(_repository.findByAuthor(author));
        return _repository.findAll();
    }

    /**
     * Add a new book to the database
     * @param author provided in request parameters
     * @param title provided in request parameters
     * @param year provided in request parameters
     * @return All books including the newly added ones
     */

    @GetMapping("/add")
    public Iterable<Book> addBooks(
        @RequestParam("author") String author,
        @RequestParam("title") String title,
        @RequestParam("year") int year
    ){
        _repository.save(new Book(0, title, author, year));
        return _repository.findAll();
    }
}