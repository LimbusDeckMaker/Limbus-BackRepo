package com.example.demo.repository;

import com.example.demo.domain.egoSkill.EgoSkill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EgoSkillRepository extends JpaRepository<EgoSkill, Long> {
}
