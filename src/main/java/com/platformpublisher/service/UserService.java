package com.platformpublisher.service;

import com.platformpublisher.model.User;
import com.platformpublisher.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class UserService {

    private final UserRepository userRepository;

    public void save(User user) {
        user.setCreatedAt(LocalDate.now());
        user.setAccountActivity(true);
        userRepository.save(user);
    }
}
