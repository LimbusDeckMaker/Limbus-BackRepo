package com.example.limbusDeckMaker.dto.response;

import com.example.limbusDeckMaker.domain.Identity;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class IdentityContext {
    private final Identity identity;
    private final List<String> resources;
    private final List<String> types;
    private final Integer minWeight;
    private final Integer maxWeight;
    private final Integer minSpeed;
    private final Integer maxSpeed;
}
