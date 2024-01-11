package com.example.demo.repository;

import com.example.demo.domain.Sinner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SinnerRepository extends JpaRepository<Sinner, Long> {

    Optional<Sinner> findByName(String sinnerName);
}
