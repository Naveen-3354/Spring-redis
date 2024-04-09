package com.example.Springredis.service;

import com.example.Springredis.model.Tutorial;
import com.example.Springredis.repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TutorialService {
    @Autowired
    TutorialRepository tutorialRepository;

    public Tutorial add(Tutorial tutorial){
        return tutorialRepository.save(tutorial);
    }

    @Cacheable(value = "tutorials")
    public List<Tutorial> findAll() {
        doLongRunningTask();

        return tutorialRepository.findAll();
    }

    @Cacheable("tutorials")
    public List<Tutorial> findByTitleContaining(String title) {
        doLongRunningTask();

        return tutorialRepository.findByTitle(title);
    }

    @Cacheable(value = "tutorial",key = "#Id")
    public Tutorial findById(String id) {
        doLongRunningTask();

        return tutorialRepository.findById(id).get();
    }

    @Cacheable("published_tutorials")
    public List<Tutorial> findByPublished(boolean isPublished) {
        doLongRunningTask();

        return tutorialRepository.findByPublished(isPublished);
    }

    private void doLongRunningTask() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}