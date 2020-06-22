package org.wcci.blog;

import org.springframework.stereotype.Controller;

@Controller
public class HashTagController {
    private HashTagRepository hashTagRepo;

    public HashTagController(HashTagRepository hashTagRepo){
        this.hashTagRepo = hashTagRepo;

    }
}
