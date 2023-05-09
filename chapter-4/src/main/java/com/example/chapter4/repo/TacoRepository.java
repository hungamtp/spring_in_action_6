package com.example.chapter4.repo;

import com.example.chapter4.entity.Taco;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface TacoRepository extends MongoRepository<Taco , String> {
    @Query("{name:'?0'}")
    Taco findItemByName(String name);
}
