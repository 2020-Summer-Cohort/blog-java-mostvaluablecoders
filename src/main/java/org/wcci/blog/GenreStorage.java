package org.wcci.blog;

import org.springframework.stereotype.Service;

@Service
public class GenreStorage {
    private GenreRepository genreRepo;

    public GenreStorage(GenreRepository genreRepo){
        this.genreRepo = genreRepo;
    }
    public Iterable<Genre> findAllGenres() {
        return genreRepo.findAll();
    }

    public Genre findGenreByName(String genre) {
        return genreRepo.findByName(genre);
    }
}
