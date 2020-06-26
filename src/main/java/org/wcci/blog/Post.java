package org.wcci.blog;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

@Entity
public class Post {
    @Id
    @GeneratedValue
    private long id;
    private String title;
    @ManyToOne
    private Author author;
    private String body;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate publishDate;
    @ManyToOne
    private Genre genre;
    @ManyToMany
    private Collection<HashTag> hashTags;

    protected Post() {
    }

    public Post(String title, Author author, String body, LocalDate publishDate, Genre genre, HashTag... hashTags) {
        this.title = title;
        this.author = author;
        this.body = body;
        this.publishDate = publishDate;
        this.genre = genre;
        this.hashTags = new ArrayList<>(Arrays.asList(hashTags));
    }

    public String getTitle() {
        return title;
    }

    public long getId() {
        return id;
    }

    public Author getAuthor() {
        return author;
    }

    public String getBody() {
        return body;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public Genre getGenre() {
        return genre;
    }

    public Collection<HashTag> getHashTags() {
        return hashTags;
    }

    public void addHashTag(HashTag hashtag) {
        hashTags.add(hashtag);
    }
}
