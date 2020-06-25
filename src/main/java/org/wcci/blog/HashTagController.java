package org.wcci.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HashTagController {
    private HashTagRepository hashTagRepo;
    private PostStorage postStorage;

    public HashTagController(HashTagRepository hashTagRepo, PostStorage postStorage){
        this.hashTagRepo = hashTagRepo;
        this.postStorage = postStorage;
    }

    @GetMapping("tags/{name}")
    public String showSingleTag(@PathVariable String name, Model model) {
        model.addAttribute("tagToDisplay", hashTagRepo.findByName(name));
        return "tag-template";
    }
}
