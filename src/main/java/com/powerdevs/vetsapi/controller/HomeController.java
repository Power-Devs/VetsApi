package com.powerdevs.vetsapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class HomeController {

    @GetMapping("/")
    @ResponseBody
    public String home(){
        return  "<p>Vets-Api - Api Rest que que localiza a clínica veterinária mais próxima</p>\n"+
                "<p>Rotas:<p>\n"+
                "<p>GET /location  sending a request body</p>\n"+
                "<p>GET /details?id=placeId</p>\n";
    }

}
