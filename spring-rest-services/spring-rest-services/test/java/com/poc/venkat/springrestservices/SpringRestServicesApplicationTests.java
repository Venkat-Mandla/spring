package com.poc.venkat.springrestservices;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.poc.venkat.springrestservices.api.service.BusinessLogicService;
import com.poc.venkat.springrestservices.domain.Address;
import com.poc.venkat.springrestservices.domain.Customer;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@EnableWebMvc
@AutoConfigureMockMvc
class SpringRestServicesApplicationTests {

	@LocalServerPort
	private int port;

	private String baseURI = "http://localhost:" + port + "/api/";

	@MockBean
	private BusinessLogicService service;

	@Autowired
	private MockMvc mockMvc;
	
	private ObjectMapper objectMapper;
	
	@BeforeEach
	public void setUp() {
		objectMapper=new ObjectMapper();
	}

	@Test
	void contextLoads() {
	}

	@Test
	public void testApi() throws Exception {
		Customer customer=new Customer();
		customer.setName("Venkat");
		customer.setId("1");
		customer.setAddress(new Address());
		Mockito.when(service.processTestLogic("venkat")).thenReturn(customer);

		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(baseURI + "/customer?name=venkat")
				.accept(MediaType.APPLICATION_JSON);
		ResultActions response = mockMvc.perform(requestBuilder);
		MvcResult returnedResponse = response.andReturn();
		MockHttpServletResponse servletResponse = returnedResponse.getResponse();
		assertEquals(HttpStatus.OK, HttpStatus.valueOf(servletResponse.getStatus()));
		assertEquals(objectMapper.writeValueAsString(customer), servletResponse.getContentAsString());
	}

}
