package com.example.limbusDeckMaker.dto;

import com.example.limbusDeckMaker.domain.Sinner;
import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link Sinner}
 */

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SinnerDto implements Serializable {
    Long id;
    String name;
    String image;
    List<EgoDto> egos;
}