package com.example.limbusDeckMaker.dto.response;

import com.example.limbusDeckMaker.domain.Ego;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EgoContext {
    private final Ego ego;
    private final List<String> resources;
    private final List<String> types;
    private final Integer minWeight;
    private final Integer maxWeight;

}