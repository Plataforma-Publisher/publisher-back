package com.platformpublisher.resource;

import com.platformpublisher.exception.BadRequestException;
import com.platformpublisher.dto.request.UserRequestDTO;
import com.platformpublisher.dto.response.UserResponseDTO;
import com.platformpublisher.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.ValidationException;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class UserResource {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDTO> saveUser(@RequestBody @Valid UserRequestDTO userRequestDTO)
            throws ValidationException {
        return userService.saveUser(userRequestDTO);
    }

    @GetMapping("/{userId}")
    public UserResponseDTO getUser(@PathVariable @Valid Long userId) throws BadRequestException {
        return userService.getUserById(userId);
    }
}

