package org.wcci.blog;

import org.springframework.stereotype.Service;

@Service
public class HashTagStorage {

    private HashTagRepository hashTagRepo;

    public Iterable<HashTag> findAllHashTags() {
        return hashTagRepo.findAll();
    }
}
