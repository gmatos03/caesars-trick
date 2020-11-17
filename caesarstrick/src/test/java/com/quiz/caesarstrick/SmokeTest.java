package com.quiz.caesarstrick;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.quiz.caesarstrick.controller.CaesarsTrickController;

@SpringBootTest
public class SmokeTest {
	
	@Autowired
	private CaesarsTrickController controller;

	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}
}
