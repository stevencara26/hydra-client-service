package com.revature.hydra.client.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.EndClient;

/**
 * EndClientRepository Data Access Object with various methods to communicate with database
 *
 */
@Repository
public interface EndClientRepository extends JpaRepository<EndClient, Integer> {

	/**
	 * Find an end client by endclientId.
	 * 
	 * @param endclientId
	 * @return EndClient
	 */
	EndClient findOneByEndClientId(Integer endclientId);

	/**
	 * Find all EndClients.
	 * 
	 * @return List of EndClients
	 */
	List<EndClient> findAll();

}
