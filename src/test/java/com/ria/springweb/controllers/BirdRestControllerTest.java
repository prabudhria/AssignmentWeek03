package com.ria.springweb.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.ria.springweb.entities.Bird;
import com.ria.springweb.service.BirdService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(SpringExtension.class)
@WebMvcTest
class BirdRestControllerTest {

    private static final int ID = 1;
    private static final String BIRDNAME = "albatross";
    private static final String BIRDFAMILY = "albatrossfamily";
    private static final ArrayList<String> CONTINENTS = new ArrayList<>(Arrays.asList("Asia", "Africa"));
    private static final String BIRDADDED = "addedatthistime";
    private static final Boolean BIRDVISIBLE = true;
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BirdService birdService;

    @Test
    public void testgetBirds() throws Exception {
        Bird samplebird = new Bird(ID, BIRDNAME, BIRDFAMILY, CONTINENTS, BIRDADDED, BIRDVISIBLE);
        List<Bird> birdslist = List.of(samplebird);
        when(birdService.getBirds()).thenReturn(birdslist);

        mockMvc.perform(MockMvcRequestBuilders.get("/birds")).andExpect(MockMvcResultMatchers.status().isOk());

//        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
//        mockMvc.perform(MockMvcRequestBuilders.get("/birds")).andExpect(MockMvcResultMatchers.content().json("[{'id':something, name: 'albatross', 'family': 'albatrossfamily', 'added': 'addedatthistime', 'visible': true}]"));
//        mockMvc.perform(MockMvcRequestBuilders.get("/birds")).andExpect(MockMvcResultMatchers.content().json(objectWriter.writeValueAsString(birdslist)));
    }

    @Test
    public void testaddBird() throws Exception {
        Bird samplebird = new Bird(ID, BIRDNAME, BIRDFAMILY, CONTINENTS, BIRDADDED, BIRDVISIBLE);
        when(birdService.addBird(any())).thenReturn(samplebird);

        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(MockMvcRequestBuilders.post("/birds").contentType(MediaType.APPLICATION_JSON).content(objectWriter.writeValueAsString(samplebird))).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testupdateBird() throws Exception {
        Bird samplebird = new Bird(ID, BIRDNAME, BIRDFAMILY, CONTINENTS, BIRDADDED, BIRDVISIBLE);
        samplebird.setName("sparrow");
        when(birdService.addBird(any())).thenReturn(samplebird);
        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(MockMvcRequestBuilders.put("/birds").contentType(MediaType.APPLICATION_JSON).content(objectWriter.writeValueAsString(samplebird))).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testdeleteBird() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/birds/{ID}", 1)).andExpect(MockMvcResultMatchers.status().isOk());
    }

}