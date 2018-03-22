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

import com.revature.beans.EndClient;
import com.revature.hydra.client.service.EndClientService;

@RestController
@CrossOrigin
@EnableAutoConfiguration
public class EndClientController {

	private EndClientService endClientService;
	
	@Autowired 
	public void setEndClientService(EndClientService endClientService) {
		this.endClientService = endClientService;
	}
	
	/**
	 * Retrieves an end client by id
	 * @param id
	 * @return ResponseEntity<EndClient>
	 */
	@RequestMapping(value = "/one/endclient/{id}", method = RequestMethod.GET)
    //@ResponseBody
    public ResponseEntity<EndClient> findOneEndClient(@PathVariable Integer id) {
    	EndClient c = endClientService.findOneById(id);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }
	
	/**
	 * Retrieves all end clients
	 * @return ResponseEntity<List<EndClient>>
	 */
	@RequestMapping(value = "/all/endclient", method = RequestMethod.GET)
    //@ResponseBody
    public ResponseEntity<List<EndClient>> findAllEndClient() {
    	List<EndClient> lc = endClientService.findAll();
        return new ResponseEntity<>(lc, HttpStatus.OK);
    }
}
