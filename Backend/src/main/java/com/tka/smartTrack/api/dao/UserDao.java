package com.tka.smartTrack.api.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tka.smartTrack.api.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, String> {

    // 🔐 login helper
    Optional<User> findByUsername(String username);

    // 🎭 role based
    List<User> findByRole(String role);

}