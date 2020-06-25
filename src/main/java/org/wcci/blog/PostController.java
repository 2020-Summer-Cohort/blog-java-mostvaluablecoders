package org.wcci.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PostController {

    PostStorage postStorage;
    GenreStorage genreStorage;

    public PostController(PostStorage postStorage) {
        this.postStorage = postStorage;
    }

    @RequestMapping("posts/{title}")
    public String showSinglePost(@PathVariable String title, Model model) {
        model.addAttribute("postToDisplay", postStorage.findPostByTitle(title));
        return "post-template";
    }

    @RequestMapping("posts/")
    public String showSinglePost(Model model) {
        model.addAttribute("allPosts", postStorage.findAllPosts());
        return "all-posts-template";
    }

}
