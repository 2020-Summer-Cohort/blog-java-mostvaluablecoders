package org.wcci.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
public class PostController {

    PostStorage postStorage;
    GenreStorage genreStorage;
    AuthorStorage authorStorage;

    public PostController(PostStorage postStorage, GenreStorage genreStorage, AuthorStorage authorStorage) {
        this.postStorage = postStorage;
        this.genreStorage = genreStorage;
        this.authorStorage = authorStorage;
    }

    @RequestMapping("posts/{title}")
    public String showSinglePost(@PathVariable String title, Model model) {
        model.addAttribute("postToDisplay", postStorage.findPostByTitle(title));
        return "post-template";
    }

    @RequestMapping("posts/new-post")
    public String routeToForm(Model model) {
        model.addAttribute("allAuthors", authorStorage.findAllAuthors());
        model.addAttribute("allGenres", genreStorage.findAllGenres());
        return "form-template";
    }

    @RequestMapping("posts/")
    public String showSinglePost(Model model) {
        model.addAttribute("allPosts", postStorage.findAllPosts());
        return "all-posts-template";
    }

    @PostMapping("posts/add")
    public String addPost(String title, String author, String body, LocalDate publishDate, String genre) {
        Author postAuthor = authorStorage.findAuthorByName(author);
        Genre postGenre = genreStorage.findGenreByName(genre);
        postStorage.save(new Post(title, postAuthor, body, publishDate, postGenre));
        return "redirect:/";
    }
//        reviewCheeseCategory));
//        return "redirect:/categories/"+ reviewCheeseCategory.getCheeseType();
//    }

}
