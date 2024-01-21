package com.example.limbusDeckMaker.util;

import java.util.Map;

public class SinnerNameMapping {

    private static final Map<String, String> NAME_MAPPING = Map.ofEntries(
            Map.entry("YiSang", "이상"),
            Map.entry("Faust", "파우스트"),
            Map.entry("DonQuixote", "돈키호테"),
            Map.entry("RyoShu", "로슈"),
            Map.entry("Meursault", "뫼르소"),
            Map.entry("HongLu", "홍루"),
            Map.entry("Heathcliff", "히스클리프"),
            Map.entry("Ishmael", "이스마엘"),
            Map.entry("Rodion", "로쟈"),
            Map.entry("Sinclair", "싱클레어"),
            Map.entry("Outis", "오티스"),
            Map.entry("Gregor", "그레고르")
    );


    private static String getKoreanName(String englishName) {
        return NAME_MAPPING.getOrDefault(englishName, englishName);
    }

    public static String extractSinnerFromFile(String fileName) {
        fileName = fileName.replace(".json", "");
        fileName = fileName.replace("Data", "");
        return getKoreanName(fileName);
    }

}
