package com.quiz.caesarstrick;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import com.quiz.caesarstrick.domain.CypherRequest;
import com.quiz.caesarstrick.domain.CypherResponse;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {
	
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void apiShouldReturnCypheredMessage() throws Exception {
		
		CypherRequest request = new CypherRequest();
		request.setRequest("123Test");
		
		CypherResponse response = new CypherResponse();
		response.setResponse("123whvw");
		
		assertThat(this.restTemplate.postForObject("http://localhost:" + port + "/api/v1/caesarstrick/cypher",
				request, CypherResponse.class)).isEqualTo(response);
	}
}
