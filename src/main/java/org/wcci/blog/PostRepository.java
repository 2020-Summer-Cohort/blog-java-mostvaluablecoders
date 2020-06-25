package org.wcci.blog;

import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post,Long> {

    Post findPostByTitle (String title);
}
