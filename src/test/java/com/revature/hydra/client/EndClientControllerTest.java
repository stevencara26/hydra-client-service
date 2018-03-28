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
import com.revature.beans.EndClient;
import com.revature.hydra.client.application.ClientRepositoryServiceApplication;
import com.revature.hydra.client.data.EndClientRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ClientRepositoryServiceApplication.class)
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EndClientControllerTest {
	@Autowired
	private WebApplicationContext webApplicationContext;
	
    private HttpMessageConverter mappingJackson2HttpMessageConverter;
	
    @Autowired
	EndClientRepository endClientRepository;

	private MockMvc mockMvc;

	private EndClient testEndClient;
	private EndClient createEndClient;
	
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
		this.testEndClient = new EndClient(0, "TEST EndCLIENT");
		this.testEndClient = this.endClientRepository.save(this.testEndClient);
	}

	@After
	public void tearDown() throws Exception {
		int testId = this.testEndClient.getEndClientId();
		if (endClientRepository.findOne(testId) != null) {
			endClientRepository.delete(testId);
		}
	}

	@Test
	public void testOneEndClientById() throws Exception {
		System.out.println("atest");
		this.mockMvc.perform(get("/one/endclient/" + this.testEndClient.getEndClientId()))
					.andExpect(status().isOk())
					.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
					.andExpect(jsonPath("$.endClientId", is(this.testEndClient.getEndClientId())))
					.andExpect(jsonPath("$.endClientName", is(this.testEndClient.getEndClientName())));
	}

	@Test
	public void testAllEndClient() throws Exception {
		System.out.println("atest");
		this.mockMvc.perform(get("/all/endclient"))
					.andExpect(status().isOk())
					.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
		}

	@Test
	public void testCreateEndClient() throws Exception {
		this.createEndClient = new EndClient();
		this.createEndClient.setEndClientName("ADDTESTClient");
		this.mockMvc.perform(post("/endclient/create")
					.content(this.json(createEndClient))
					.contentType(mediaTypeJson))
					.andExpect(status().isCreated());
	}
	
	@Ignore
	@Test
	public void testUpdateEndClient() throws Exception {
		this.testEndClient = this.endClientRepository.findOne(this.testEndClient.getEndClientId());
		this.testEndClient.setEndClientName("UPDATETESTEndClient");
		this.mockMvc.perform(put("/endclient/update")
					.content(this.json(this.testEndClient))
					.contentType(this.mediaTypeJson))
					.andExpect(status().isOk());
	}
	
	@Ignore
	@Test
	public void testDeleteEndClient() throws Exception {
		this.mockMvc.perform(delete("/endclient/delete/" + this.testEndClient.getEndClientId()))
					.andExpect(status().isOk());
	}
	
	protected String json(Object obj) throws IOException {
		MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
		this.mappingJackson2HttpMessageConverter.write(obj, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
		return mockHttpOutputMessage.getBodyAsString();
	}
	
}
