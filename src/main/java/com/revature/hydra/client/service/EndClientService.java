package com.revature.hydra.client.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.EndClient;
import com.revature.hydra.client.data.EndClientRepository;

/**
 * EndClientService
 * 
 * EndClient services implementation with communication with EndClientRepository
 */
@Service
public class EndClientService {

	@Autowired
	private EndClientRepository endClientRepository;
	
	/**
	 * Saving a endClient
	 * 
	 * @param endClient - endClient to save
	 */
	public void save(EndClient endClient) {
		endClientRepository.save(endClient);
	}
	
	/**
	 * Update a endClient
	 * 
	 * @param endClient - endClient to update
	 */
	public void update(EndClient endClient) {
		save(endClient);
	}
	
	/**
	 * Delete a endClient
	 * 
	 * @param endClient - endClient to delete
	 */
	public void delete(EndClient endClient) {
		endClientRepository.delete(endClient.getEndClientId());
	}

	/**
	 * Obtain list of all endClients from endClientRepository.
	 * 
	 * @return List<EndClient> - List of endClients
	 */
	public List<EndClient> findAll(){
		return endClientRepository.findAll();
	}

	/**
	 * Obtain a endClient from endClientRepository with given endClientId.
	 * 
	 * @param endClientId
	 * @return EndClient - The client object with given endClientId
	 */
	public EndClient findOneById(Integer endClientId) {
		return endClientRepository.findOneByEndClientId(endClientId);
	}
}
