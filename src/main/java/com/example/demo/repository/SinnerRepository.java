package com.example.demo.repository;

import com.example.demo.domain.Sinner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SinnerRepository extends JpaRepository<Sinner, Long> {

}
