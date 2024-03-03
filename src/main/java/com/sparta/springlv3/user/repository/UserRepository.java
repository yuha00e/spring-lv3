package com.sparta.springlv3.user.repository;

import com.sparta.springlv3.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    //    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
}


