package com.example.limbusDeckMaker.repository;

import com.example.limbusDeckMaker.domain.Identity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IdentityRepository extends JpaRepository<Identity, Long> {
    Optional<Identity> findBySinner_NameAndName(String sinnerName, String identityName);
}