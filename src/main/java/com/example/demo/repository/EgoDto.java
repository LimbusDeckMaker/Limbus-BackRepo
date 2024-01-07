package com.example.demo.repository;

import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link com.example.demo.domain.Ego}
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