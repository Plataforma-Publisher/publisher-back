package com.platformpublisher.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class UserResponseDTO {
    private String id;
    private String fullName;
    private String nameUser;
    private String email;
    private String linkedIn;
    private String github;
    private String createdAt;
    private String accountActivity;

}
