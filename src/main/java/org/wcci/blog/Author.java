package org.wcci.blog;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;
@Entity
public class Author {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @OneToMany (mappedBy = "author")
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

