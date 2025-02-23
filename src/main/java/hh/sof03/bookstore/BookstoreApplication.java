package hh.sof03.bookstore;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof03.bookstore.domain.Book;
import hh.sof03.bookstore.domain.Category;

import hh.sof03.bookstore.domain.BookRepository;
import hh.sof03.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

    @Bean
    public CommandLineRunner dataLoader(BookRepository bookRepository, CategoryRepository categoryRepository) {
        return args -> {
            Category sciFi = new Category("Romance");
            Category fantasy = new Category("Fantasy");
            categoryRepository.save(sciFi);
            categoryRepository.save(fantasy);
    
            bookRepository.save(new Book("A Farewell to Arms", "Ernest Hemingway", 1929, "1232323-21"));
            bookRepository.save(new Book("Animal Farm", "George Orwell", 1945, "2212343-5"));
        };
    }
}
