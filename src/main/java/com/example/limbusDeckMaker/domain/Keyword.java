package com.example.limbusDeckMaker.domain;

import com.example.limbusDeckMaker.dto.KeywordDto;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@Table(name = "keyword")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class Keyword {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String content;

    public static Keyword toEntity(KeywordDto dto) {
        return Keyword.builder()
                .name(dto.getName())
                .content(dto.getContent())
                .build();
    }
}