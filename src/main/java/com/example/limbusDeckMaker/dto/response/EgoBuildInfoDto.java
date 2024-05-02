package com.example.limbusDeckMaker.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class EgoBuildInfoDto {

    private String character;
    private List<Ego> egos;

    public static EgoBuildInfoDto toDto(String character, List<Ego> egos) {
        return EgoBuildInfoDto.builder()
                .character(character)
                .egos(egos)
                .build();
    }


    @Getter
    @Setter
    public static class Ego {
        private Integer num;
        private List<String> resourcesNum;

        public Ego(Integer num, List<String> resourcesNum) {
            this.num = num;
            this.resourcesNum = resourcesNum;
        }
    }

}
