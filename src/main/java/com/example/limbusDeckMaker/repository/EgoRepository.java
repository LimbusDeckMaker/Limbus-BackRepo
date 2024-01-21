package com.example.limbusDeckMaker.repository;

import com.example.limbusDeckMaker.domain.Ego;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EgoRepository extends JpaRepository<Ego, Long> {

    @Override
    Optional<Ego> findById(Long aLong);


}
