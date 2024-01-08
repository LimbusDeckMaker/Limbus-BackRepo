package com.example.demo.dto;

import com.example.demo.domain.Ego.Ego;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link Ego}
 */
@Value
public class EgoDto implements Serializable {
    Long id;
    String name;
    String image;
    Byte grade;
    String passive;
    LocalDate releaseDate;
    String obtainingMethod;
}