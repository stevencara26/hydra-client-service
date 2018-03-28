package com.revature.hydra.client;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.revature.beans.Client;
import com.revature.hydra.client.application.ClientRepositoryServiceApplication;
import com.revature.hydra.client.data.ClientRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ClientRepositoryServiceApplication.class)
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClientControllerTest {

	@Autowired
	private WebApplicationContext webApplicationContext;
	
    private HttpMessageConverter mappingJackson2HttpMessageConverter;
	
    @Autowired
	ClientRepository clientRepository;

	private MockMvc mockMvc;

	private Client testClient;
	private Client createClient;
	
	@Autowired
    void setConverters(HttpMessageConverter<?>[] converters) {

        this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream()
            .filter(hmc -> hmc instanceof MappingJackson2HttpMessageConverter)
            .findAny()
            .orElse(null);

        assertNotNull("the JSON message converter must not be null",
                this.mappingJackson2HttpMessageConverter);
    }
	
	private final String mediaTypeJson = MediaType.APPLICATION_JSON_UTF8_VALUE;
	
	@Before
	public void setUp() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		this.testClient = new Client(0, "TEST CLIENT");
		this.testClient = this.clientRepository.save(this.testClient);
	}

	@After
	public void tearDown() throws Exception {
		int testId = this.testClient.getClientId();
		if (clientRepository.findOne(testId) != null) {
			clientRepository.delete(testId);
		}
	}

	@Test
	public void testOneClientById() throws Exception {
		System.out.println("atest");
		this.mockMvc.perform(get("/one/client/" + this.testClient.getClientId()))
					.andExpect(status().isOk())
					.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
					.andExpect(jsonPath("$.clientId", is(this.testClient.getClientId())))
					.andExpect(jsonPath("$.clientName", is(this.testClient.getClientName())));
	}

	@Test
	public void testAllClient() throws Exception {
		System.out.println("atest");
		this.mockMvc.perform(get("/all/client"))
					.andExpect(status().isOk())
					.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
		}

	@Test
	public void testCreateClient() throws Exception {
		this.createClient = new Client();
		this.createClient.setClientName("ADDTESTClient");
		this.mockMvc.perform(post("/client/create")
					.content(this.json(createClient))
					.contentType(mediaTypeJson))
					.andExpect(status().isCreated());
	}
	
	@Ignore
	@Test
	public void testUpdateClient() throws Exception {
		this.testClient = this.clientRepository.findOne(this.testClient.getClientId());
		this.testClient.setClientName("UPDATETESTClient");
		this.mockMvc.perform(put("/client/update")
					.content(this.json(this.testClient))
					.contentType(this.mediaTypeJson))
					.andExpect(status().isOk());
	}
	
	@Ignore
	@Test
	public void testDeleteClient() throws Exception {
		this.mockMvc.perform(delete("/client/delete/" + this.testClient.getClientId()))
					.andExpect(status().isOk());
	}
	
	protected String json(Object obj) throws IOException {
		MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
		this.mappingJackson2HttpMessageConverter.write(obj, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
		return mockHttpOutputMessage.getBodyAsString();
	}
	
}
