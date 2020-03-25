package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BootController {

    private final BookRepository bookRepository;

    //this constructor is needed to add an instance of the bookRepository into our class
    public BootController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    public String getBooks(Model model) {

        // when spring makes a request to /books url, this method is going to provide
        // a model object which has a name of books and contains a list of books
        model.addAttribute("books", bookRepository.findAll());

        return "books";
    }
}
