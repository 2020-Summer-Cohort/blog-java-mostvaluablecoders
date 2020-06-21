package org.wcci.blog;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

import java.util.Set;

public class Post {
    @Id
    @GeneratedValue
    private long id;
    private String title;
    private Set<Author> authors;
    private String body;
    private LocalDateTime publishDate;
    private String category;


    private Set<HashTag> hashTags;


    public Post(long id, String title, Set<Author> authors, String body, LocalDateTime publishDate, String category, Set<HashTag> hashTags) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.body = body;
        this.publishDate = publishDate;
        this.category = category;
        this.hashTags = hashTags;
    }

    public String getTitle() {
        return title;
    }

    public long getId() {
        return id;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public String getBody() {
        return body;
    }

    public LocalDateTime getPublishDate() {
        return publishDate;
    }

    public String getCategory() {
        return category;
    }

    public Set<HashTag> getHashTags() {
        return hashTags;
    }
}
