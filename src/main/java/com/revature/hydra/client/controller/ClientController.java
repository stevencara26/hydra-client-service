package com.revature.hydra.client.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Client;
import com.revature.hydra.client.service.ClientService;

@RestController
@CrossOrigin
@EnableAutoConfiguration
public class ClientController {
	
	private ClientService clientService;
	
	@Autowired
	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}
	

    @RequestMapping(value = "/one/client/{id}", method = RequestMethod.GET)
    //@ResponseBody
    public ResponseEntity<Client> findOneClient(@PathVariable Integer id) {
    	Client c = clientService.findOneById(id);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/all/client", method = RequestMethod.GET)
    //@ResponseBody
    public ResponseEntity<List<Client>> findAllClient() {
    	List<Client> lc = clientService.findAll();
        return new ResponseEntity<>(lc, HttpStatus.OK);
    }

}