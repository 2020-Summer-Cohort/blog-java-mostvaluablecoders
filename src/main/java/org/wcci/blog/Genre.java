package org.wcci.blog;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
public class Genre {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @OneToMany(mappedBy = "genre")
    private Collection<Post> posts;


    protected Genre(){}

    public Genre(String name){

        this.name = name;
        this.posts = posts;


    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Collection<Post> getPosts() {
        return posts;
    }


}
