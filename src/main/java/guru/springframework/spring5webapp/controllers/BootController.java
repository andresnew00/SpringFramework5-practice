package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BootController {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    //this constructor is needed to add an instance of the bookRepository into our class
    public BootController(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/books")
    public String getBooks(Model model) {

        // when spring makes a request to /books url, this method is going to provide
        // a model object which has a name of books and contains a list of books
        model.addAttribute("books", bookRepository.findAll());

        //this will point at the templates package look into books and use list.html
        return "books/list";
    }

    @RequestMapping("/authors")
    public String getAuthors(Model model) {
        model.addAttribute("authors", authorRepository.findAll());

        return "books/authorlist";
    }
}
