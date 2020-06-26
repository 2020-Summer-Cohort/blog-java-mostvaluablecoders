package org.wcci.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    AuthorStorage authorStorage;
    AuthorRepository authorRepo;

    public AuthorController(AuthorStorage authorStorage, AuthorRepository authorRepo) {
        this.authorStorage = authorStorage;
        this.authorRepo = authorRepo;
    }

    @RequestMapping("authors/{author}")
    public String routeToAuthorPage(@PathVariable String author, Model model) {
        model.addAttribute("author", authorStorage.findAuthorByName(author));
        return "author-template";
    }

    @PostMapping("authors/add")
    public String addAuthor(String name) {
        Author author = new Author(name);
        authorRepo.save(author);
        return "redirect:/genres/";
    }

}
