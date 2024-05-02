package com.example.limbusDeckMaker.service.mapper;

import com.example.limbusDeckMaker.domain.Identity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class IdentityBuildInfoMapper {

    public static List<Integer> countIdentityResources(Identity identity){
        List<String> resourceNames = Arrays.asList("분노", "색욕", "나태", "탐식", "우울", "오만", "질투");
        List<Integer> resourceCounts = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0));

        Stream.of(
                    identity.getIdentitySkill1().stream().filter(s -> s.getLevel() == 4).map(s -> s.getSkill1().getSkill1Info().getResource()),
                    identity.getIdentitySkill2().stream().filter(s -> s.getLevel() == 4).map(s -> s.getSkill2().getSkill2Info().getResource()),
                    identity.getIdentitySkill3().stream().filter(s -> s.getLevel() == 4).map(s -> s.getSkill3().getSkill3Info().getResource()),
                    identity.getIdentityDefSkill().stream().filter(s -> s.getLevel() == 4).map(s -> s.getDefSkill().getDefSkillInfo().getResource())
                )
                .flatMap(Function.identity())
                .forEach(resource -> {
                    int index = resourceNames.indexOf(resource);
                    if (index != -1){
                        resourceCounts.set(index, resourceCounts.get(index) + 1);
                    }
                });

        return resourceCounts;
    }

    public static List<Integer> countIdentityTypes(Identity identity){
        List<String> typeNames = Arrays.asList("참격", "관통", "타격");
        List<Integer> typeCounts = new ArrayList<>(Arrays.asList(0, 0, 0));

        Stream.of(
                    identity.getIdentitySkill1().stream().filter(s -> s.getLevel() == 4).map(s -> s.getSkill1().getSkill1Info().getType()),
                    identity.getIdentitySkill2().stream().filter(s -> s.getLevel() == 4).map(s -> s.getSkill2().getSkill2Info().getType()),
                    identity.getIdentitySkill3().stream().filter(s -> s.getLevel() == 4).map(s -> s.getSkill3().getSkill3Info().getType()),
                    identity.getIdentityDefSkill().stream().filter(s -> s.getLevel() == 4).map(s -> s.getDefSkill().getDefSkillInfo().getType())
                )
                .flatMap(Function.identity())
                .forEach(type -> {
                    int index = typeNames.indexOf(type);
                    if (index != -1){
                        typeCounts.add(index, typeCounts.get(index) + 1);
                    }
                });

        return typeCounts;
    }
}
