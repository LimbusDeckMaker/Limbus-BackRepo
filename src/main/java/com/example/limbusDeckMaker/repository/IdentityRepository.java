package com.example.limbusDeckMaker.repository;

import com.example.limbusDeckMaker.domain.Identity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IdentityRepository extends JpaRepository<Identity, Long> {
}