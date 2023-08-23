package com.ria.springweb.service;

import com.ria.springweb.entities.Bird;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BirdService {

//    Bird samplebird = new Bird(1, "albatross", "phasianidae", "2023081531", true);
    HashMap<Integer, Bird> hashMap = new HashMap<>();

    public List<Bird> getBirds() {
        return new ArrayList<>(hashMap.values());
    }

    public Bird getBird(int id){
        return hashMap.get(id);
    }

    public Bird addBird(Bird bird) {
        hashMap.put(bird.getId(), bird);
        return hashMap.get(bird.getId());
    }

    public Bird updateBird(Bird bird){
        hashMap.put(bird.getId(), bird);
        return hashMap.get(bird.getId());
    }

    public void deleteBird(int id){
        hashMap.remove(id);
    }
}
