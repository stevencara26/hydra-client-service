package com.revature.hydra.client.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Client;
import com.revature.hydra.client.data.ClientRepository;

/**
 * ClientService
 * 
 * Client services implementation with communication with ClientRepository
 */
@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;

	/**
	 * Saving a client
	 * 
	 * @param client - client to save
	 */
	public void save(Client client) {
		clientRepository.save(client);
	}

	/**
	 * Update a client
	 * 
	 * @param client - client to update
	 */
	public void update(Client client) {
		save(client);
	}

	/**
	 * Delete a client
	 * 
	 * @param client - client to delete
	 */
	public void delete(Client client) {
		clientRepository.delete(client.getClientId());
	}

	/**
	 * Obtain list of all clients from clientRepository.
	 * 
	 * @return List<Client> - List of clients
	 */
	public List<Client> findAll() {
		return clientRepository.findAll();
	}

	/**
	 * Obtain a client from clientRepository with given clientId.
	 * 
	 * @param clientId
	 * @return client - The client object with given clientId
	 */
	public Client findOneById(Integer clientId) {
		//These two methods exist by default in the repository, should have the same function.
		//return clientRepository.getOne(clientId);
		//return clientRepository.findOne(clientId);
		return clientRepository.findOneById(clientId);
	}
	
	
	

}
