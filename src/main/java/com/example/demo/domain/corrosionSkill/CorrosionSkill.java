package com.example.demo.domain.corrosionSkill;
import com.example.demo.domain.corrosionSkill.imbeddable.Sync3Info;
import com.example.demo.domain.ego.Ego;
import com.example.demo.util.StringListConverter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "corrosion_skill")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class CorrosionSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("ego_name")
    private String name;

    private String image;

    @JsonProperty("resistance")
    @Convert(converter = StringListConverter.class)
    private List<String> resistance;

    @Embedded
    @JsonProperty("sync3")
    private Sync3Info sync3Info;

    private Byte construeLevel;

    // Ego와의 관계 - 다대일
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ego_id")
    private Ego ego;

}