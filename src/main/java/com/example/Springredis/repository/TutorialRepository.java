package com.example.Springredis.repository;

import com.example.Springredis.model.Tutorial;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TutorialRepository extends MongoRepository<Tutorial,String> {
    List<Tutorial> findByTitle(String title);

    List<Tutorial> findByPublished(boolean isPublished);
}
