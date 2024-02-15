package com.example.limbusDeckMaker.imbeddable.identity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Passive {
    private PassiveInfo passiveInfo;
}
