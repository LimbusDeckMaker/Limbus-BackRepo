package com.example.demo.repository;

import com.example.demo.domain.ego.Ego;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EgoRepository extends JpaRepository<Ego, Long> {

    @Override
    Optional<Ego> findById(Long aLong);

}
