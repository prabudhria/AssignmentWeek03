package com.ria.springweb.service;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.ria.springweb.entities.Bird;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.naming.BinaryRefAddr;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
class BirdServiceTest {

    BirdService birdService = new BirdService();
    Bird bird;

    private static final int ID = 1;
    private static final String BIRDNAME = "albatross";
    private static final String UPDATEDBIRDNAME = "peacock";
    private static final String BIRDFAMILY = "albatrossfamily";
    private static final ArrayList<String> CONTINENTS = new ArrayList<>(Arrays.asList("Asia", "Africa"));
    private static final String BIRDADDED = "addedatthistime";
    private static final Boolean BIRDVISIBLE = true;

    @BeforeEach
    public void initializer(){
        bird = new Bird(ID, BIRDNAME, BIRDFAMILY, CONTINENTS, BIRDADDED, BIRDVISIBLE);
    }


    @Test
    void testgetBirds() {
        birdService.addBird(bird);

        List<Bird> birds = birdService.getBirds();
        Bird createdBird = birds.get(0);

        assertEquals(ID, createdBird.getId());
        assertEquals(BIRDNAME, createdBird.getName());
        assertEquals(BIRDFAMILY, createdBird.getFamily());
        assertEquals(CONTINENTS, createdBird.getContinents());
        assertTrue(createdBird.isVisible());
    }
    @Test
    void testGetBird() {
        birdService.addBird(bird);

        Bird receivedBird = birdService.getBird(ID);

        assertEquals(ID, receivedBird.getId());

        assertEquals(BIRDNAME, receivedBird.getName());
        assertEquals(BIRDFAMILY, receivedBird.getFamily());
        assertEquals(CONTINENTS, receivedBird.getContinents());
        assertTrue(receivedBird.isVisible());
    }

    @Test
    void testAddBird() {
        birdService.addBird(bird);

        Bird addedBird = birdService.getBird(ID);

        assertEquals(ID, addedBird.getId());
        assertEquals(BIRDNAME, addedBird.getName());
        assertEquals(BIRDFAMILY, addedBird.getFamily());
        assertEquals(CONTINENTS, addedBird.getContinents());
        assertTrue(addedBird.isVisible());
    }

    @Test
    void testUpdateBird() {
        birdService.addBird(bird);

        bird.setName(UPDATEDBIRDNAME);
        Bird createdBird = birdService.updateBird(bird);

        assertEquals(ID, createdBird.getId());
        assertEquals(UPDATEDBIRDNAME, createdBird.getName());
        assertEquals(BIRDFAMILY, createdBird.getFamily());
        assertEquals(CONTINENTS, createdBird.getContinents());
        assertTrue(createdBird.isVisible());
    }

    @Test
    void testDeleteBird() {
        birdService.myMap.put(ID, bird);
        assertEquals(1, birdService.myMap.size());

        birdService.deleteBird(ID);

        assertNull(birdService.myMap.get(ID));

    }
}