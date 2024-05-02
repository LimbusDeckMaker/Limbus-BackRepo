package com.example.limbusDeckMaker.repository;

import com.example.limbusDeckMaker.domain.Ego;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EgoRepository extends JpaRepository<Ego, Long>, JpaSpecificationExecutor<Ego> {

    @Override
    Optional<Ego> findById(Long aLong);

    Optional<Ego> findBySinner_NameAndName(String sinnerName, String egoName);

    List<Ego> findByIdIn(List<Long> ids);
}
