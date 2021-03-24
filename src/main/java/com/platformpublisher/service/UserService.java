package com.platformpublisher.service;

import com.platformpublisher.dto.request.UserRequestDTO;
import com.platformpublisher.dto.response.UserResponseDTO;
import com.platformpublisher.mapper.UserMapper;
import com.platformpublisher.model.User;
import com.platformpublisher.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class UserService {

    private final UserRepository userRepository;
    private static final UserMapper userMapper = UserMapper.INSTANCE;

    public ResponseEntity<UserResponseDTO> save(UserRequestDTO userRequestDTO) {
        User userToSave = userMapper.toModel(userRequestDTO);

        userToSave.setCreatedAt(LocalDate.now());
        userToSave.setAccountActivity(true);
        User savedUser = userRepository.save(userToSave);

        return new ResponseEntity(userMapper.toDto(savedUser), HttpStatus.CREATED);
    }
}
