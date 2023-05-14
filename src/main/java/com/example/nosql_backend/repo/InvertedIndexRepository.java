package com.example.nosql_backend.repo;

import com.example.nosql_backend.entity.invertedindex;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InvertedIndexRepository extends MongoRepository<invertedindex, String> {
    invertedindex findByWord(String word);
}
