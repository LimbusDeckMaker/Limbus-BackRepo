package com.example.limbusDeckMaker.service.mapper;

import com.example.limbusDeckMaker.domain.Identity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Stream;

public class IdentityListInfoMapper {

    public static List<String> findUseResources(Identity identity) {
        List<String> resources = Arrays.asList("분노", "색욕", "나태", "탐식", "우울", "오만", "질투");
        Set<String> uniqueResources = new HashSet<>();

        Stream.of(
                identity.getIdentitySkill1().stream().filter(s -> s.getLevel() == 4).map(s -> s.getSkill1().getSkill1Info().getResource()),
                identity.getIdentitySkill2().stream().filter(s -> s.getLevel() == 4).map(s -> s.getSkill2().getSkill2Info().getResource()),
                identity.getIdentitySkill3().stream().filter(s -> s.getLevel() == 4).map(s -> s.getSkill3().getSkill3Info().getResource()),
                identity.getIdentityDefSkill().stream().filter(s -> s.getLevel() == 4).map(s -> s.getDefSkill().getDefSkillInfo().getResource())
            )
            .flatMap(Function.identity())
            .forEach(resource -> {
                Arrays.stream(resource.split(",")).forEach(res -> {
                    if (resources.contains(res.trim())) {
                        uniqueResources.add(res.trim());
                    }
                });
            });

        List<String> usingResources = new ArrayList<>(uniqueResources);
        usingResources.sort(Comparator.naturalOrder());

        return usingResources;
    }

    public static List<String> findUseTypes(Identity identity) {
        Set<String> uniqueTypes = new HashSet<>();

        Stream.of(
                identity.getIdentitySkill1().stream().filter(s -> s.getLevel() == 4).map(s -> s.getSkill1().getSkill1Info().getType()),
                identity.getIdentitySkill2().stream().filter(s -> s.getLevel() == 4).map(s -> s.getSkill2().getSkill2Info().getType()),
                identity.getIdentitySkill3().stream().filter(s -> s.getLevel() == 4).map(s -> s.getSkill3().getSkill3Info().getType()),
                identity.getIdentityDefSkill().stream().filter(s -> s.getLevel() == 4).map(s -> s.getDefSkill().getDefSkillInfo().getType())
            )
            .flatMap(Function.identity())
            .forEach(uniqueTypes::add);

        List<String> usingTypes = new ArrayList<>(uniqueTypes);
        usingTypes.sort(Comparator.naturalOrder());

        return usingTypes;
    }


    public static Integer parseMinSpeed(String speed) {
        String[] parts = speed.split("-");
        return Integer.parseInt(parts[0].trim());
    }

    public static Integer parseMaxSpeed(String speed) {
        String[] parts = speed.split("-");
        return Integer.parseInt(parts[1].trim());
    }

    public static Integer findMinWeight(Identity identity) {
        return Stream.of(
                identity.getIdentitySkill1().stream().filter(s -> s.getLevel() == 4)
                    .mapToInt(s -> s.getSkill1().getSkill1Info().getAtkWeight()),
                identity.getIdentitySkill2().stream().filter(s -> s.getLevel() == 4)
                    .mapToInt(s -> s.getSkill2().getSkill2Info().getAtkWeight()),
                identity.getIdentitySkill3().stream().filter(s -> s.getLevel() == 4)
                    .mapToInt(s -> s.getSkill3().getSkill3Info().getAtkWeight())
            )
            .flatMapToInt(s -> s)
            .min()
            .orElse(Integer.MAX_VALUE);
    }

    public static Integer findMaxWeight(Identity identity) {
        return Stream.of(
                identity.getIdentitySkill1().stream().filter(s -> s.getLevel() == 4)
                    .mapToInt(s -> s.getSkill1().getSkill1Info().getAtkWeight()),
                identity.getIdentitySkill2().stream().filter(s -> s.getLevel() == 4)
                    .mapToInt(s -> s.getSkill2().getSkill2Info().getAtkWeight()),
                identity.getIdentitySkill3().stream().filter(s -> s.getLevel() == 4)
                    .mapToInt(s -> s.getSkill3().getSkill3Info().getAtkWeight())
            )
            .flatMapToInt(s -> s)
            .max()
            .orElse(Integer.MIN_VALUE);
    }


}
