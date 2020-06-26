package org.wcci.blog;

import org.springframework.stereotype.Service;

@Service
public class GenreStorage {
    private GenreRepository genreRepo;
    private PostRepository postRepo;

    public GenreStorage(GenreRepository genreRepo, PostRepository postRepo){
        this.genreRepo = genreRepo;
        this.postRepo = postRepo;
    }
    public Iterable<Genre> findAllGenres() {
        return genreRepo.findAll();
    }

    public Genre findGenreByName(String genre) {
        return genreRepo.findByName(genre);
    }
}
