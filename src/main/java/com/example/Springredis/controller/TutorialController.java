package com.example.Springredis.controller;

import com.example.Springredis.model.Tutorial;
import com.example.Springredis.service.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class TutorialController {

    @Autowired
    private TutorialService service;

    @PostMapping
    public Tutorial add(@RequestBody Tutorial tutorial){
        return service.add(tutorial);
    }

    @GetMapping
    public List<Tutorial> getAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Tutorial getById(@PathVariable String id){
        return service.findById(id);
    }


}
