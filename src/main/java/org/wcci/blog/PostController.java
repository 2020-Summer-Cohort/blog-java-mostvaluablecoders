package org.wcci.blog;

import org.springframework.stereotype.Controller;

@Controller
public class PostController {

    PostStorage postStorage;
    public PostController(PostStorage postStorage){
        this.postStorage = postStorage;
    }
}
