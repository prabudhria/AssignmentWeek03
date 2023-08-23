package com.ria.springweb.controllers;

import com.ria.springweb.entities.Bird;
import com.ria.springweb.service.BirdService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BirdRestController {
    BirdService birdService = new BirdService();
    @RequestMapping(value = "/birds", method = RequestMethod.GET)
    public List<Bird> getBirds(){
        return birdService.getBirds();
    }

    @RequestMapping(value = "/birds/{id}", method = RequestMethod.GET)
    public Bird getBird(@PathVariable("id") int id){
        return birdService.getBird(id);
    }

    @RequestMapping(value = "/birds", method = RequestMethod.POST)
    public Bird addBird(@RequestBody Bird bird){ return birdService.addBird(bird);
    }

    @RequestMapping(value = "/birds", method = RequestMethod.PUT)
    public Bird updateBird(@RequestBody Bird bird){
        return birdService.updateBird(bird);
    }

    @RequestMapping(value = "/birds/{id}", method = RequestMethod.DELETE)
    public void deleteBird(@PathVariable("id") int id){
        birdService.deleteBird(id);
    }

}
