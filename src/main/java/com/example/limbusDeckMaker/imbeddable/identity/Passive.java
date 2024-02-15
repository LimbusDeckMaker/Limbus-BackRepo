package com.example.limbusDeckMaker.imbeddable.identity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Embeddable;
import lombok.*;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Passive {
    private PassiveInfo passiveInfo;
}
