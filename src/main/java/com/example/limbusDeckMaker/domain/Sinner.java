package com.example.limbusDeckMaker.domain;

import com.example.limbusDeckMaker.dto.SinnerDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "sinner")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Builder
public class Sinner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String image;

    // Ego와의 관계 - 일대다
    @OneToMany(mappedBy = "sinner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ego> egos;

    public static Sinner toEntity(SinnerDto dto){
        return Sinner.builder()
                .name(dto.getName())
                .build();
    }
}
