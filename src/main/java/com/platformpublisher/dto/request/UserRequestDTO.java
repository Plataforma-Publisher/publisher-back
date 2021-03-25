package com.platformpublisher.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class UserRequestDTO {

    @NotEmpty(message = "The full name must be informed")
    @Size(max = 150)
    private String fullName;

    @Size(max = 30) private String nameUser;

    @Email
    @NotEmpty(message = "The email must be informed")
    @Size(max = 50, message = "Email must be a maximum of 50 characters")
    private String email;

    @NotEmpty (message = "The password must be informed")
    @Size(max = 50, message = "Password must be a maximum of 50 characters")
    private String password;

    private String linkedIn;
    private String github;

}
