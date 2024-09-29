package com.example.cinemille.repository.jpa;

import com.example.cinemille.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
