package org.wcci.blog;

import org.springframework.stereotype.Service;

@Service
public class PostStorage {
    PostRepository postRepository;

    private PostStorage(PostRepository postRepository){
        this.postRepository = postRepository;
    }

}
