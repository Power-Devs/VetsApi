package com.powerdevs.vetsapi.controller;

import com.powerdevs.vetsapi.entity.Location;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class LocationControllerTest {

    @Autowired
    private MockMvc mockMVC;

    URI uri;

    Location local = new Location(-23.7075796,-46.7951825,8000);

    @Before
    public void before() throws Exception{
        uri = new URI("/location");

    }
    //TODO: teste quebrado pelo CORS
    @Test
    public void testaSeRotaEstaOnline() throws Exception {
        mockMVC.perform(MockMvcRequestBuilders
                .get(uri))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}