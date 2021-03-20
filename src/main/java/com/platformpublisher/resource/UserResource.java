package com.platformpublisher.resource;

import com.platformpublisher.model.User;
import com.platformpublisher.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class UserResource {

    private final UserService userService;

    @PostMapping
    public void save(@RequestBody User user) {
        userService.save(user);
    }
}

