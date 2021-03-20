package com.platformpublisher;

import com.platformpublisher.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class UserTest {

	@Test
	void addUser() {
		User user = User.builder()
				.nameUser("Sidney Miranda")
				.build();
		String expectedName = "Sidney Miranda";
		String currentName = user.getNameUser();

		assertEquals(expectedName, currentName);
	}
}
