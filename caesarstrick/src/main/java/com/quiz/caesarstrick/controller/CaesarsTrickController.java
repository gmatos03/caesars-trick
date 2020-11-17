package com.quiz.caesarstrick.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.caesarstrick.domain.CypherRequest;
import com.quiz.caesarstrick.domain.CypherResponse;
import com.quiz.caesarstrick.service.CaesarsTrickService;

@RestController
@RequestMapping("/api/v1/caesarstrick")
public class CaesarsTrickController {

	@Autowired
	private CaesarsTrickService service;
	
	@PostMapping("/cypher")
	public ResponseEntity<?> cypherText(@RequestBody CypherRequest request){

		CypherResponse response = service.cypherText(request);
		//response.setResponse(request.getRequest());
		return new ResponseEntity<CypherResponse>(response, HttpStatus.CREATED);
	}
	
	@PostMapping("/decypher")
	public ResponseEntity<?> deCypherText(@RequestBody CypherRequest request){
		
		CypherResponse response = service.deCypherText(request);
		//response.setResponse(request.getRequest());
		return new ResponseEntity<CypherResponse>(response, HttpStatus.CREATED);
	}
}
