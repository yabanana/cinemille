package com.example.cinemille.repository.jpa;

import com.example.cinemille.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieJpaRepository extends JpaRepository<Movie, Long> {
    // Metodi specifici se necessari
}
