package org.wcci.blog;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class Populator implements CommandLineRunner {
    @Autowired
    GenreRepository genreRepo;
    @Autowired
    PostRepository postRepo;
    @Autowired
    HashTagRepository hashTagRepo;
    @Autowired
    AuthorRepository authorRepo;

    @Override
    public void run(String... args) throws Exception {
        Genre frontEnd = new Genre("Front-End");
        Genre backEnd = new Genre("Back-End");
        genreRepo.save(frontEnd);
        genreRepo.save(backEnd);

        HashTag html = new HashTag("HTML");
        HashTag css = new HashTag("CSS");
        HashTag java = new HashTag("Java");

        hashTagRepo.save(html);
        hashTagRepo.save(css);
        hashTagRepo.save(java);

        Author john = new Author("John");
        Author jd = new Author("JD");

        authorRepo.save(john);
        authorRepo.save(jd);

        LocalDate date1 = LocalDate.of(2020,6,24);
        LocalDate date2 = LocalDate.of(2020,6,25);

        Post post1 = new Post("Test", john, "This is a test post.", date1, frontEnd, html);
        Post post2 = new Post("Test2", jd, "This is a test post.", date2, backEnd, java);

        postRepo.save(post1);
        postRepo.save(post2);

    }
}