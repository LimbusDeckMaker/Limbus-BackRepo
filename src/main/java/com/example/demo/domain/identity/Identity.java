package com.example.demo.domain.identity;

import com.example.demo.domain.Sinner;
import com.example.demo.domain.identity.imbeddable.Status;
import com.example.demo.util.StringListConverter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "identity")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Setter
@Getter
public class Identity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("name")
    private String name;

    private String image;

    private String sync3Image;

    @Convert(converter = StringListConverter.class)
    private List<String> resistance;

    @Embedded
    @JsonProperty("sync3")
    private Status status;

    @JsonProperty("position")
    private String affiliation;

    @JsonProperty("rank")
    private Integer grade;

    @JsonProperty("birth")
    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate releaseDate;

    @JsonProperty("get")
    private String obtainingMethod;

    @Convert(converter = StringListConverter.class)
    @JsonProperty("keyword")
    private List<String> keyword;

    // Sinner - 다대일
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sinner_id")
    private Sinner sinner;

    // IdentityPassive, IdentitySupPassive - 일대일
    @OneToOne(mappedBy = "identity", cascade = CascadeType.ALL, orphanRemoval = true)
    private IdentityPassive identityPassive;

    @OneToOne(mappedBy = "identity", cascade = CascadeType.ALL, orphanRemoval = true)
    private IdentitySupPassive identitySupPassive;

}
