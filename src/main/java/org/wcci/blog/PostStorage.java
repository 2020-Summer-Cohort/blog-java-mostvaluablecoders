package org.wcci.blog;

import org.springframework.stereotype.Service;

@Service
public class PostStorage {
    PostRepository postRepository;

    private PostStorage(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    public Post findPostByTitle(String title) {
        return postRepository.findPostByTitle(title);
    }

    public Author findAuthorByTitle(String title) {
        return postRepository.findAuthorByTitle(title);
    }
}
