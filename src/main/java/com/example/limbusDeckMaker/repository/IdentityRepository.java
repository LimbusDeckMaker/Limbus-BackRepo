package com.example.limbusDeckMaker.repository;

import com.example.limbusDeckMaker.domain.Identity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IdentityRepository extends JpaRepository<Identity, Long>,
    JpaSpecificationExecutor<Identity> {

    Optional<Identity> findBySinner_NameAndName(String sinnerName, String identityName);
}