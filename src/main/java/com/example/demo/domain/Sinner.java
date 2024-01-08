package com.example.demo.domain;

import com.example.demo.domain.ego.Ego;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "sinner")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class Sinner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String character;

    private String image;

    // Ego와의 관계 - 일대다
    @OneToMany(mappedBy = "sinner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ego> egos;

}
