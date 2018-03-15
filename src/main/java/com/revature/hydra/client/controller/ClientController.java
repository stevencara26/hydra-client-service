package com.revature.hydra.client.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class ClientController {

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }

}