package com.revature.hydra.client.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Client;

/**
 * ClientRepository Data Access Object with various methods to communicate with database
 *
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

	/**
	 * Find a client by clientId.
	 * 
	 * @param clientId
	 * @return Client
	 */
	Client findOneById(Integer clientId);

	/**
	 * Find all Clients.
	 * 
	 * @return List of Clients
	 */
	List<Client> findAll();

}
