package com.quiz.caesarstrick;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quiz.caesarstrick.controller.CaesarsTrickController;
import com.quiz.caesarstrick.domain.CypherRequest;
import com.quiz.caesarstrick.domain.CypherResponse;
import com.quiz.caesarstrick.service.CaesarsTrickService;

@WebMvcTest(CaesarsTrickController.class)
public class WebMockTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CaesarsTrickService service;

	@Test
	public void greetingShouldReturnMessageFromService() throws Exception {

		CypherRequest request = new CypherRequest();
		request.setRequest("123Test");

		CypherResponse response = new CypherResponse();
		response.setResponse("123whvw");
		
		when(service.cypherText(request)).thenReturn(response);
		this.mockMvc.perform((RequestBuilder) ((ResultActions) MockMvcRequestBuilders.post("/api/v1/caesarstrick/cypher")
			      .content(asJsonString(request))).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("123whvw"))));
	}
	
	public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
}
