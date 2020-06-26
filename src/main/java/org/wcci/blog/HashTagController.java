package org.wcci.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HashTagController {
    private HashTagStorage hashTagStorage;
    private PostStorage postStorage;

    public HashTagController(HashTagStorage hashTagStorage, PostStorage postStorage) {
        this.hashTagStorage = hashTagStorage;
        this.postStorage = postStorage;
    }

    @GetMapping("tags/{name}")
    public String showSingleTag(@PathVariable String name, Model model) {
        model.addAttribute("tagToDisplay", hashTagStorage.findByName(name));
        return "tag-template";
    }

    @RequestMapping("tags/")
    public String routeToAllTagsTemplate(Model model) {
        model.addAttribute("tags",hashTagStorage.findAllHashTags());
        return "all-tags-template";
    }

    @PostMapping("tags/add")
    public String addTag(String tag, String post) {
        Post tagPost = postStorage.findPostByTitle(post);

        HashTag hashtag = hashTagStorage.findByName(tag);
        if (hashtag == null) {
            hashtag = new HashTag(tag);
            hashTagStorage.save(hashtag);
        }
        tagPost.addHashTag(hashtag);
        postStorage.save(tagPost);
        return "redirect:/posts/" + post;
    }

}
