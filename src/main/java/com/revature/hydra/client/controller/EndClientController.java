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

import com.revature.beans.EndClient;
import com.revature.hydra.client.service.EndClientService;

@RestController
@CrossOrigin
@EnableAutoConfiguration
public class EndClientController {

	private static final Logger log = Logger.getLogger(EndClientController.class);

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
		log.info("Finding endclient with endClientId: " + id);
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
    	log.info("Finding all endclients...");
    	List<EndClient> lc = endClientService.findAll();
        return new ResponseEntity<>(lc, HttpStatus.OK);
    }

	/**
	 * Create end client
	 *
	 * @param endclient to save
	 * @return the response entity with saved end client
	 */
	@RequestMapping(value = "/endclient/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EndClient> createEndClient(@Valid @RequestBody EndClient endclient) {
		log.info("Saving endclient: " + endclient);
		endClientService.save(endclient);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	/**
	 * Update end client
	 *
	 * @param endclient to update
	 * @return the response entity
	 */
	@RequestMapping(value = "/endclient/update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> updateEndClient(@Valid @RequestBody EndClient endclient) {
		log.info("Updating endclient: " + endclient);
		endClientService.update(endclient);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	/**
	 * Delete end client
	 *
	 * @param id 
	 * @return the response entity
	 */
	@RequestMapping(value = "/endclient/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteEndClient(@PathVariable int id) {
		EndClient endclient = new EndClient();
		endclient.setEndClientId(id);
		log.info("Deleting endclient: " + id);
		endClientService.delete(endclient);
		return new ResponseEntity<>(HttpStatus.OK);
	}


}
