package com.revature.hydra.client.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Client;
import com.revature.hydra.client.service.ClientService;

@RestController
@CrossOrigin
@EnableAutoConfiguration
public class ClientController {
	
	private static final Logger log = Logger.getLogger(ClientController.class);
	
	private ClientService clientService;
	
	@Autowired
	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}
	
	/**
	 * Retrieves a client by id
	 * @param id
	 * @return ResponseEntity<Client>
	 */
    
	@RequestMapping(value = "/one/client/{id}", method = RequestMethod.GET)
    //@ResponseBody
    public ResponseEntity<Client> findOneClient(@PathVariable Integer id) {
		log.info("Finding client with clientId: " + id);
		Client c = clientService.findOneById(id);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }
    
    /**
     * Retrieves all clients
     * @return ResponseEntity <List<Client>>
     */
    @RequestMapping(value = "/all/client", method = RequestMethod.GET)
    //@ResponseBody
    public ResponseEntity<List<Client>> findAllClient() {
    	log.info("Finding all clients...");
    	List<Client> lc = clientService.findAll();
        return new ResponseEntity<>(lc, HttpStatus.OK);
    }

    /**
	 * Create client
	 *
	 * @param client to save
	 * @return the response entity with saved client
	 */
	@RequestMapping(value = "/client/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Client> createClient(@Valid @RequestBody Client client) {
		log.info("Saving client: " + client);
		clientService.save(client);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	/**
	 * Update client
	 *
	 * @param client to update
	 * @return the response entity
	 */
	@RequestMapping(value = "/client/update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> updateClient(@Valid @RequestBody Client client) {
		log.info("Updating client: " + client);
		clientService.update(client);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	/**
	 * Delete client
	 *
	 * @param id 
	 * @return the response entity
	 */
	@RequestMapping(value = "/client/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteClient(@PathVariable int id) {
		Client client = new Client();
		client.setClientId(id);
		log.info("Deleting client: " + id);
		clientService.delete(client);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}