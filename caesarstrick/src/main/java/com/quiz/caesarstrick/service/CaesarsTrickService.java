package com.quiz.caesarstrick.service;

import org.springframework.stereotype.Service;

import com.quiz.caesarstrick.domain.CypherRequest;
import com.quiz.caesarstrick.domain.CypherResponse;

@Service
public class CaesarsTrickService {

	public CypherResponse cypherText(CypherRequest request) {
		
		char letter;
		String cyphered = "";
		String text = request.getRequest().toLowerCase();
		
		for(int i = 0; i < text.length(); i++) {
			letter = text.charAt(i);
			
			if(letter >= 'a' && letter <= 'z') {
				letter = (char) (letter + 3);
			}
			cyphered = cyphered + letter;
		}
		CypherResponse response = new CypherResponse();
		response.setResponse(cyphered);
		return response;
	}
	
	public CypherResponse deCypherText(CypherRequest request) {

		char letter;
		String decyphered = "";
		String text = request.getRequest().toLowerCase();
		
		for(int i = 0; i < text.length(); i++) {
			letter = text.charAt(i);
			
			if(letter >= 'a' && letter <= 'z') {
				letter = (char) (letter - 3);
			}
			decyphered = decyphered + letter;
		}
		CypherResponse response = new CypherResponse();
		response.setResponse(decyphered);
		return response;
	}
}
