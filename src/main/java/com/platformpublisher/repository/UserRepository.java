package com.platformpublisher.repository;

import com.platformpublisher.enums.UserType;
import com.platformpublisher.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByIdAndAccountActivity(Long id, UserType accountActivity);
}
