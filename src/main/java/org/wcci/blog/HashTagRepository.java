package org.wcci.blog;

import org.springframework.data.repository.CrudRepository;

public interface HashTagRepository extends CrudRepository<HashTag, Long> {


    HashTag findByName(String name);
}
