package org.wcci.blog;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.Set;
@Entity
public class Author {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @OneToMany (mappedBy = "author")
    private Collection<Post> posts;


    public Author(String name) {
        this.name = name;
    }



    public Author(){}

    public String getName() {
        return name;
    }
    public Long getId() {
        return id;
    }

    public Collection<Post> getPosts() {
        return posts;
    }
}

