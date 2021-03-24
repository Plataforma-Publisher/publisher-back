package com.platformpublisher;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.platformpublisher.dto.request.UserRequestDTO;
import com.platformpublisher.service.UserService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;


@SpringBootTest
class UserTest {

	@Autowired
	private UserService service;

	@Test
	@AutoConfigureMockMvc
	@Disabled
	void addUser() throws JsonProcessingException {
		UserRequestDTO userRequest = UserRequestDTO.builder()
				.fullName("Sidney Miranda")
				.nameUser("ssm")
				.email("sidney@gmail.com")
				.password("12345")
				.build();

	}
}
