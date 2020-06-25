package org.wcci.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HashTagController {
    private HashTagRepository hashTagRepo;
    private HashTagStorage hashTagStorage;
    private PostStorage postStorage;

    public HashTagController(HashTagRepository hashTagRepo, HashTagStorage hashTagStorage, PostStorage postStorage){
        this.hashTagRepo = hashTagRepo;
        this.hashTagStorage = hashTagStorage;
        this.postStorage = postStorage;
    }

    @GetMapping("tags/{name}")
    public String showSingleTag(@PathVariable String name, Model model) {
        model.addAttribute("tagToDisplay", hashTagRepo.findByName(name));
        return "tag-template";
    }

    @RequestMapping("tags/")
    public String routeToAllTagsTemplate() {
        return "all-tags-template";
    }
}
