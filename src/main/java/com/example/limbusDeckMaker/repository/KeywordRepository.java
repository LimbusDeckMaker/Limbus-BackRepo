package com.example.limbusDeckMaker.repository;

import com.example.limbusDeckMaker.domain.Keyword;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KeywordRepository extends JpaRepository<Keyword, Long> {
}