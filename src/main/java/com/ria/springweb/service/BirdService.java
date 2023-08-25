package com.ria.springweb.service;

import com.ria.springweb.entities.Bird;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Service
public class BirdService {
    HashMap<Integer, Bird> myMap;

    public BirdService(){
        myMap = new HashMap<>();
    }
    public List<Bird> getBirds() {
        return new ArrayList<>(myMap.values());
    }

    public Bird getBird(int id){
        return myMap.get(id);
    }

    public Bird addBird(Bird bird) {
        myMap.put(bird.getId(), bird);
        return myMap.get(bird.getId());
    }

    public Bird updateBird(Bird bird){
        myMap.put(bird.getId(), bird);
        return myMap.get(bird.getId());
    }

    public void deleteBird(int id){
        myMap.remove(id);
    }
}
