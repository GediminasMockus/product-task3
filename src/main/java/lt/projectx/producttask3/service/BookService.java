package lt.projectx.producttask3.service;

import lombok.RequiredArgsConstructor;
import lt.projectx.producttask3.entity.Book;
import lt.projectx.producttask3.repository.BookRepository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;


    public void addTestBooks() {
        for (int i = 0; i < 10; i++) {
            Book book = new Book();
            book.setYear(2023);
            book.setAuthor("Author " + i);
            book.setGenre("Genre " + (i % 3));
            book.setHolding("Available");
            book.setTitle("Title " + i);
            bookRepository.save(book);
        }
    }

    public void addNewBook(int year, int id, String author, String genre, String holding, String title) {
        Book book = new Book();
        book.setYear(year);
        book.setAuthor(author);
        book.setGenre(genre);
        book.setHolding(holding);
        book.setTitle(title);
        bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public void updateBookHolding(Long id, String holding) {
        bookRepository.countByGenreIgnoreCaseAndYear("Fantasy", 2018);
        Book book = bookRepository.findById(id).get();
        book.setHolding(holding);
        bookRepository.save(book);
    }

    public List<Book> getAllBooksByGenre(String genre) {
        return bookRepository.findAllByGenre(genre);
    }

    public List<Book> getAllBooksByGenreAndYear(String genre, int year) {
        return bookRepository.findByGenreAndYear("Knygos pagal zanra ir metus " + genre, year);
    }

    public long countCurentYearFantasyBooks() {
        int year = LocalDate.now().getYear();
        System.out.println("Ieškome knygų žanru: Fantasy ir metais: " + year);
        long count = bookRepository.countByGenreIgnoreCaseAndYear("Fantasy", year);
        System.out.println("Surasta knygų: " + count);
        return count;
    }

}