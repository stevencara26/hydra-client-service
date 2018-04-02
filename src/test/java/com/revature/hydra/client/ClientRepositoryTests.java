package com.revature.hydra.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.beans.Client;
import com.revature.hydra.client.application.ClientRepositoryServiceApplication;
import com.revature.hydra.client.data.ClientRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= ClientRepositoryServiceApplication.class)

public class ClientRepositoryTests {
	private static final Logger Log = Logger.getLogger(ClientRepositoryTests.class);
	
	@Autowired
	ClientRepository clientRepository;

	Client testClient;

	Integer Testid;
	
	/**
	 * Setup test environment for each test case.
	 */
	@Before
	public void init() {
		Log.info("Initalizing a Test Client for use in Tests");
		testClient = new Client();
		testClient.setClientName("Test_Name");
		testClient = clientRepository.save(testClient);

	}

	/**
	 * Clean up the changes made by every test.
	 */
	@After
	public void teardown() {
		Log.info("Tear down");
		if (clientRepository.findOneByClientId(testClient.getClientId()) != null) {
			clientRepository.delete(testClient);
		}
	}

	/**
	 * Test adding a client to database by clientRepository.save(client)
	 */
	@Test
	public void addClient() {
		Log.info("Test adding a client.");
		testClient = new Client(5, "Test_Name2");
		Client savedClient = clientRepository.save(testClient);
		Testid = savedClient.getClientId();
		
		assertTrue(clientRepository.findAll().contains(savedClient));
	}

	/**
	 * Test getting a client by clientId through clientRepository.findOneByClientId(clientId)
	 */
	@Test
	public void findOneByClientId() {
		Log.info("Test getting a client by clientId.");
		Client client = clientRepository.findOneByClientId(testClient.getClientId());

		assertEquals(testClient, client);
	}

	/**
	 * Test getting all clients by clientRepository.findAll()
	 */
	@Test
	public void findAll() {
		Log.info("Test getting all clients.");
		List<Client> clients = clientRepository.findAll();

		assertFalse(clients.isEmpty());
	}

	
	/**
	 * Test updating an existing client by clientRepository.save(client)
	 */
	@Test
	public void updateClient() {
		Log.info("Test updating a client.");
		testClient.setClientId(Testid);
		Client updatedClient = clientRepository.save(testClient);

		assertEquals(updatedClient.getClientId(), testClient.getClientId());
	}

	/**
	 * Test deleting a client by clientRepository.delete(client)
	 */
	@Test
	public void deleteClient() {
		Log.info("Test deleting a client.");
		clientRepository.delete(testClient);

		assertNull(clientRepository.findOneByClientId(testClient.getClientId()));
	}

}


