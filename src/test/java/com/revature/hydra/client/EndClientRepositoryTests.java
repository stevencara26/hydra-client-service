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
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.beans.Client;
import com.revature.beans.EndClient;
import com.revature.hydra.client.application.ClientRepositoryServiceApplication;
import com.revature.hydra.client.data.ClientRepository;
import com.revature.hydra.client.data.EndClientRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= ClientRepositoryServiceApplication.class)
public class EndClientRepositoryTests {
	private static final Logger Log = Logger.getLogger(EndClientRepositoryTests.class);

	@Autowired
	EndClientRepository endClientRepository;

	EndClient testEndClient;
	
	Integer Testid;

	@Before
	public void init() {
		Log.info("Initalizing a Test EndClient for use in Tests");
		testEndClient = new EndClient();
		testEndClient.setEndClientName("Test_Name");
		testEndClient = endClientRepository.save(testEndClient);

	}

	@After
	public void teardown() {
		Log.info("Tear down");
		if (endClientRepository.findOneByEndClientId(testEndClient.getEndClientId()) != null) {
			endClientRepository.delete(testEndClient);
		}
	}

	@Test
	public void addEndClient() {
		Log.info("Test adding a client.");
		testEndClient = new EndClient(5, "Test_Name2");
		EndClient savedEndClient = endClientRepository.save(testEndClient);
		Testid = savedEndClient.getEndClientId();
		assertTrue(endClientRepository.findAll().contains(savedEndClient));
	}

	@Test
	public void findOneByClientId() {
		Log.info("Test getting a endclient by endclienttId.");
		EndClient endclient = endClientRepository.findOneByEndClientId(testEndClient.getEndClientId());

		assertEquals(testEndClient, endclient);
	}

	@Test
	public void findAll() {
		Log.info("Test getting all endclients.");
		List<EndClient> endclients = endClientRepository.findAll();

		assertFalse(endclients.isEmpty());
	}

	

	@Test
	public void updateEndClient() {
		Log.info("Test updating a endclient.");
		testEndClient.setEndClientId(Testid);
		EndClient updatedEndClient = endClientRepository.save(testEndClient);

		assertEquals(updatedEndClient.getEndClientId(), testEndClient.getEndClientId());
	}

	@Test
	public void deleteEndClient() {
		Log.info("Test deleting a endclient.");
		endClientRepository.delete(testEndClient);

		assertNull(endClientRepository.findOneByEndClientId(testEndClient.getEndClientId()));
	}


}