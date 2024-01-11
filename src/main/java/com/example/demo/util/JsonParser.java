package com.example.demo.util;

import com.example.demo.dto.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonParser {

    public static List<EgoDto> parseJsonForEgo(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper.readValue(new File(filePath), new TypeReference<>() {
        });

    }

    public static List<EgoSkillDto> parseJsonForEgoSkill(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper.readValue(new File(filePath), new TypeReference<>() {
        });
    }

    public static List<CorrosionSkillDto> parseJsonForEgoCorrosionSkill(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper.readValue(new File(filePath), new TypeReference<>() {
        });
    }

    public static List<IdentityDto> parseJsonForIdentity(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper.readValue(new File(filePath), new TypeReference<>() {
        });
    }

    public static List<IdentityPassiveDto> parseJsonForIdentityPassive(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper.readValue(new File(filePath), new TypeReference<>() {
        });
    }


    public static List<IdentitySkill1Dto> parseJsonForIdentitySkill1(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper.readValue(new File(filePath), new TypeReference<>() {
        });
    }

    public static List<IdentitySkill2Dto> parseJsonForIdentitySkill2(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper.readValue(new File(filePath), new TypeReference<>() {
        });
    }

    public static List<IdentitySkill3Dto> parseJsonForIdentitySkill3(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper.readValue(new File(filePath), new TypeReference<>() {
        });
    }

    public static List<IdentityDefSkillDto> parseJsonForIdentityDefSkill(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper.readValue(new File(filePath), new TypeReference<>() {
        });
    }
}
