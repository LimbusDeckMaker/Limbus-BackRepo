package com.example.demo.repository;

import com.example.demo.domain.identity.IdentityPassive;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IdentityPassiveRepository extends JpaRepository<IdentityPassive, Long> {
}