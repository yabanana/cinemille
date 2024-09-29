package com.example.cinemille.repository;

import com.example.cinemille.model.User;

public interface UserRepository extends GenericRepository<User, Long> {

    User findByUsername(String username);
}
