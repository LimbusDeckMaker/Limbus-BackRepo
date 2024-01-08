package com.example.demo.repository;

import com.example.demo.domain.corrosionSkill.CorrosionSkill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorrosionSkillRepository extends JpaRepository<CorrosionSkill, Long> {
}