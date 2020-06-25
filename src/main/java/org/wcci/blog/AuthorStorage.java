package org.wcci.blog;

import org.springframework.stereotype.Service;

@Service
public class AuthorStorage {
    private AuthorRepository authorRepo;

    public AuthorStorage(AuthorRepository authorRepo){
        this.authorRepo = authorRepo;
    }

    public Iterable<Author> findAllAuthors() {
        return authorRepo.findAll();
    }
}
