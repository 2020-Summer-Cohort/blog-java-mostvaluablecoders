package org.wcci.blog;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Set;

public class Author {

    @Id
    @GeneratedValue
    private Long id;



    private String name;
    private Set<Post> posts;

    public Author(Long id, String name, Set<Post> posts) {
        this.id = id;
        this.name = name;
        this.posts = posts;
    }



    public Author(){}

    public String getName() {
        return name;
    }
    public Long getId() {
        return id;
    }

    public Set<Post> getPosts() {
        return posts;
    }
}

