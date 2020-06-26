package org.wcci.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class GenreController{
    GenreStorage genreStorage;
    AuthorStorage authorStorage;
    GenreRepository genreRepo;

    public GenreController(GenreStorage genreStorage, AuthorStorage authorStorage, GenreRepository genreRepo) {
        this.genreStorage = genreStorage;
        this.authorStorage = authorStorage;
        this.genreRepo = genreRepo;
    }

    @RequestMapping("genres/{genre}")
    public String showASinglePost(@PathVariable String genre, Model model){
        model.addAttribute("genre",genreStorage.findGenreByName(genre));
        return "genre-template";
    }

    @RequestMapping("genres/")
    public String showAllGenres(Model model) {
        model.addAttribute("allGenres", genreStorage.findAllGenres());
        model.addAttribute("authors", authorStorage.findAllAuthors());
        return "genres-template";
    }

    @PostMapping("genres/add")
    public String addGenre(String name) {
        Genre genre = new Genre(name);
        genreRepo.save(genre);
        return "redirect:/genres/";
    }

}


