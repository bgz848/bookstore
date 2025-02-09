package hh.sof03.bookstore.web;

import java.util.List;
import hh.sof03.bookstore.domain.Book;
import hh.sof03.bookstore.domain.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/booklist")
    public String showBookList(Model model) {
        List<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);
        return "booklist"; // This maps to booklist.html
    }
}