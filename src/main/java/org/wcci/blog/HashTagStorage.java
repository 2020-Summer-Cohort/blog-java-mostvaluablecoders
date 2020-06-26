package org.wcci.blog;

import org.springframework.stereotype.Service;

@Service
public class HashTagStorage {

    private HashTagRepository hashTagRepo;

    public HashTagStorage(HashTagRepository hashTagRepo) {
        this.hashTagRepo = hashTagRepo;
    }

    public Iterable<HashTag> findAllHashTags() {
        return hashTagRepo.findAll();
    }

    public HashTag findByName(String name) {
        return hashTagRepo.findByName(name);
    }
}
