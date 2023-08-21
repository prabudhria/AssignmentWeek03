package com.ria.springweb.controllers;

import com.ria.springweb.entities.Bird;
import com.ria.springweb.respos.BirdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class BirdRestController {
    @Autowired
    BirdRepository birdRepository;

    @RequestMapping(value = "/birds", method = RequestMethod.GET)
    public List<Bird> getBirds(){
        return birdRepository.findAll();
    }

    @RequestMapping(value = "/birds/{id}", method = RequestMethod.GET)
    public Bird getBird(@PathVariable("id") int id){
        return birdRepository.findById(id).get();
    }

    @RequestMapping(value = "/birds", method = RequestMethod.POST)
    public Bird addBird(Bird bird){
        return birdRepository.save(bird);
    }

    @RequestMapping(value = "/birds", method = RequestMethod.PUT)
    public Bird updateBird(Bird bird){
        return birdRepository.save(bird);
    }

    @RequestMapping(value = "/birds/{id}", method = RequestMethod.DELETE)
    public void deleteBird(@PathVariable("id") int id){
        birdRepository.deleteById(id);
    }

}
