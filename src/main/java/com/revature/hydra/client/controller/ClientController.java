package com.revature.hydra.client.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.beans.Client;

@Controller
@CrossOrigin
@EnableAutoConfiguration
public class ClientController {

    @RequestMapping(value = "/one/client/{id}", method = RequestMethod.GET)
    //@ResponseBody
    public ResponseEntity<Client> findOneClient(@PathVariable Integer id) {
    	Client c = new Client();
    	c.setClientId(3);
    	c.setClientName("Name");
        return new ResponseEntity<>(c, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/all/client", method = RequestMethod.GET)
    //@ResponseBody
    public ResponseEntity<List<Client>> findAllClient() {
    	List<Client> lc = new ArrayList<>();
    	Client c = new Client();
    	c.setClientId(3);
    	c.setClientName("Name");
    	lc.add(c);
        return new ResponseEntity<>(lc, HttpStatus.OK);
    }

}