package com.example.limbusDeckMaker.imbeddable.identity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Embeddable
public abstract class BasePassiveList {
    private List<PassiveInfo> passiveInfo;
}
