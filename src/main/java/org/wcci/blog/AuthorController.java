package org.wcci.blog;

import org.springframework.stereotype.Controller;

@Controller
public class AuthorController {

    AuthorStorage authorStorage;

    public AuthorController(AuthorStorage authorStorage){
        this.authorStorage = authorStorage;
    }


}
