package com.platformpublisher.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class UserRequestDTO {

    @NotNull @Size(max = 150) private String fullName;

    @Size(max = 30) private String nameUser;

    @NotNull @Email @Size(max = 50) private String email;

    @NotNull @Size(max = 50) private String password;

    private String linkedIn;
    private String github;

}
