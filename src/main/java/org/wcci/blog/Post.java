package org.wcci.blog;

import javax.persistence.*;
import java.time.LocalDateTime;

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
    private LocalDateTime publishDate;
    @ManyToOne
    private Genre genre;


    protected Post(){}
    @ManyToMany
    private Collection<HashTag> hashTags;


    public Post(long id, String title, Author author, String body, LocalDateTime publishDate, Genre genre, Collection<HashTag> hashTags) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.body = body;
        this.publishDate = publishDate;
        this.genre = genre;
        this.hashTags = hashTags;
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

    public LocalDateTime getPublishDate() {
        return publishDate;
    }

    public Genre getGenre() {
        return genre;
    }

    public Collection<HashTag> getHashTags() {
        return hashTags;
    }
}
