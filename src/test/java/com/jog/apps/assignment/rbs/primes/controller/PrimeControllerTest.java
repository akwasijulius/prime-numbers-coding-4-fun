/**
 * 
 */
package com.jog.apps.assignment.rbs.primes.controller;

import static org.assertj.core.util.Lists.emptyList;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;

import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * PrimeController Integration Test
 * @author Julius Oduro
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PrimeControllerTest {
	
	
	protected MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

	@SuppressWarnings("rawtypes")
	private HttpMessageConverter mappingJackson2HttpMessageConverter;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	protected void setConverters(HttpMessageConverter<?>[] converters) {
		this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream()
				.filter(hmc -> hmc instanceof MappingJackson2HttpMessageConverter)
				.findAny()
				.orElse(null);
	}

	@SuppressWarnings("unchecked")
	protected String json(Object o) throws IOException {
		MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
		this.mappingJackson2HttpMessageConverter.write(o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
		return mockHttpOutputMessage.getBodyAsString();
	}
	
	
	@Test
	public void findPrimeNumbers() throws Exception{
		int number = 17;		
		this.mockMvc.perform(MockMvcRequestBuilders.get("/primes/" + number))
			.andExpect(status().isOk())
			.andExpect(content().contentType(this.contentType))
			.andExpect(jsonPath("$.Initial", is(number)))
			.andExpect(jsonPath("$.Primes", is(Lists.newArrayList(2, 3, 5, 7, 11, 13, 17))));
	}
	
	
	@Test
	public void findPrimeNumbersForNumberWithNoPrime() throws Exception{
		int number = 1;		
		this.mockMvc.perform(MockMvcRequestBuilders.get("/primes/" + number))
			.andExpect(status().isOk())
			.andExpect(content().contentType(this.contentType))
			.andExpect(jsonPath("$.Initial", is(number)))
			.andExpect(jsonPath("$.Primes", is(emptyList())));
	}
	
	
	@Test
	public void findPrimeNumbersForTen() throws Exception{
		int number = 10;		
		this.mockMvc.perform(MockMvcRequestBuilders.get("/primes/" + number))
			.andExpect(status().isOk())
			.andExpect(content().contentType(this.contentType))
			.andExpect(jsonPath("$.Initial", is(number)))
			.andExpect(jsonPath("$.Primes", is(Lists.newArrayList(2, 3, 5, 7))));
	}
	
	

	

}
