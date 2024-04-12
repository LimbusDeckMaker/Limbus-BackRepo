package com.example.limbusDeckMaker.imbeddable.identity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Embeddable
public class PassiveList extends BasePassiveList {
    @JsonProperty("pass1")
    private List<PassiveInfo> passiveInfo;
}
