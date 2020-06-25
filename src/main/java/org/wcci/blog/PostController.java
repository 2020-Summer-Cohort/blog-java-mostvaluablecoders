package org.wcci.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PostController {

    PostStorage postStorage;
    GenreStorage genreStorage;
    AuthorStorage authorStorage;

    public PostController(PostStorage postStorage) {
        this.postStorage = postStorage;
    }

    @RequestMapping("posts/{title}")
    public String showSinglePost(@PathVariable String title, Model model) {
        model.addAttribute("postToDisplay", postStorage.findPostByTitle(title));
        return "post-template";
    }

    @RequestMapping("posts/new-post")
    public String routeToForm(Model model) {
        model.addAttribute("authors", authorStorage.findAllAuthors());
        model.addAttribute("genres", genreStorage.findAllGenres());
        return "form-template";
    }

    @RequestMapping("posts/")
    public String showSinglePost(Model model) {
        model.addAttribute("allPosts", postStorage.findAllPosts());
        return "all-posts-template";
    }



//    @PostMapping("reviews/add")
//    public String addReview(String cheeseName, String texture, String milkSource, String geographicLocation,
//                            Integer userRating, String userReviewComment,  long cheeseCategoryId) {
//        CheeseCategory reviewCheeseCategory = cheeseCategoryStorage.findCheeseCategoryById(cheeseCategoryId);
//
//        reviewStorage.save(new Review(cheeseName, texture, milkSource, geographicLocation, userRating, userReviewComment,
//                reviewCheeseCategory));
//        return "redirect:/categories/"+ reviewCheeseCategory.getCheeseType();
//    }

}
