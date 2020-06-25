package org.wcci.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class GenreController{
    GenreStorage genreStorage;

    public GenreController(GenreStorage genreStorage) {
        this.genreStorage = genreStorage;

    }
    @RequestMapping("genres/{name}")
    public String showASinglePost(@PathVariable String name, Model model){
        model.addAttribute("genre", genreStorage.getPostByGenre(name));
        return "genre-template";
    }

    @RequestMapping("genres/")
    public String showAllGenres(Model model) {
        model.addAttribute("allGenres", genreStorage.findAllGenres());
        return "genres-template";
    }

}


