package com.platformpublisher.service;

import com.platformpublisher.dto.request.UserRequestDTO;
import com.platformpublisher.dto.response.UserResponseDTO;
import com.platformpublisher.enums.UserType;
import com.platformpublisher.exception.BadRequestException;
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


    private User verifyIfExists(Long id) throws BadRequestException {
        return userRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("User with ID " + id + " not found"));
    }

    public ResponseEntity<UserResponseDTO> saveUser(UserRequestDTO userRequestDTO) {
        User userToSave = userMapper.toModel(userRequestDTO);
        userToSave.setCreatedAt(LocalDate.now());
        userToSave.setAccountActivity(UserType.ACTIVE);
        User savedUser = userRepository.save(userToSave);

        return new ResponseEntity(userMapper.toDto(savedUser), HttpStatus.CREATED);
    }

    public UserResponseDTO getUserById(Long userId) throws BadRequestException {
        User optionalUser = verifyIfExists(userId);

        return userMapper.toDto(optionalUser);
    }

    public String updateUser(Long userId, UserRequestDTO userRequestDTO) throws BadRequestException {
        User userFound = verifyIfExists(userId);
        userMapper.updateUser(userRequestDTO, userFound);
        userRepository.save(userFound);

        return "User updated with success";
    }
}
