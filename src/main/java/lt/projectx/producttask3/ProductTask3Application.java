package lt.projectx.producttask3;

import lt.projectx.producttask3.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class ProductTask3Application {

    private final BookService bookService;

    @Autowired
    public ProductTask3Application(BookService bookService) {
        this.bookService = bookService;
    }

    public static void main(String[] args) {
        SpringApplication.run(ProductTask3Application.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        System.out.println("Application is ready");
        bookService.addTestBooks();
        bookService.addNewBook(2025, 0, "Robin", "Fantasy", "Home", "Robin hood");
        bookService.addNewBook(2018, 1, "<NAME>", "Fantasy", "Library", "<NAME>");
        bookService.addNewBook(2020, 2, "<NAME>", "Fantasy", "Library", "<NAME>");
        bookService.addNewBook(2025, 3, "<NAME>", "Fantasy", "Library", "<NAME>");
        bookService.addNewBook(1998, 4, "<NAME>", "Fantasy", "Home", "<NAME>");
        bookService.deleteBook(2L);
        bookService.updateBookHolding(1L, "Library");
        bookService.getAllBooksByGenre("Fantasy");
        bookService.getAllBooksByGenreAndYear("Fantasy", 2018);
        long count = bookService.countCurentYearFantasyBooks();
        System.out.println("Fantasy knygų tais metais: " + count);

    }

}
