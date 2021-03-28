package com.powerdevs.vetsapi.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;
import java.net.URISyntaxException;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DetailsControllerTest {

    @Autowired
    private MockMvc mockMVC;

    URI uri;

    @Before
    public void before() throws Exception{
        uri = new URI("/details?id=ChIJse5XgLxTzpQR95iuGRY9emQ");
    }

    @Test
    public void testaSeRotaEstaOnline() throws Exception {
        mockMVC.perform(MockMvcRequestBuilders.get(uri))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @Test
    public void testaSeRetornaDetalhes() throws Exception {
        mockMVC.perform(MockMvcRequestBuilders.get(uri))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("KVET CLÍNICA VETERINÁRIA E BANHO & TOSA"));
    }

    @Test
    public void testaSeDaErroComIdInvalido() throws Exception {
        uri = new URI("/details?id=ChIJse5XgLxTzpQR95iusGRY9emQ");

        try{
            mockMVC.perform(MockMvcRequestBuilders.get(uri))
                    .andExpect(MockMvcResultMatchers.status().is(500));
        }catch (Exception e){
            Assert.assertNotNull(e);
        }

    }


    @Test
    public void testaIdVazio() throws URISyntaxException {

        uri = new URI("/details");

        try{
            mockMVC.perform(MockMvcRequestBuilders.get(uri))
                    .andExpect(MockMvcResultMatchers.status().is(400));
        }catch (Exception e){
            Assert.assertNotNull(e);
        }
    }


}