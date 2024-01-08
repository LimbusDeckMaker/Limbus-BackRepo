package com.example.demo.util;

import com.example.demo.domain.corrosionSkill.CorrosionSkill;
import com.example.demo.domain.ego.Ego;
import com.example.demo.domain.egoSkill.EgoSkill;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonParser {

    public static List<Ego> parseJsonForEgo(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper.readValue(new File(filePath), new TypeReference<>() {
        });

    }

    public static List<EgoSkill> parseJsonForEgoSkill(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper.readValue(new File(filePath), new TypeReference<>() {
        });
    }

    public static List<CorrosionSkill> parseJsonForEgoCorrosionSkill(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper.readValue(new File(filePath), new TypeReference<>() {
        });
    }
}
