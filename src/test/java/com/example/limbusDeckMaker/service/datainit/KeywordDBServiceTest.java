package com.example.limbusDeckMaker.service.datainit;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class KeywordDBServiceTest {


    @Autowired
    private KeywordDBService keywordDBService;

    @Test
    void processAndSaveData() throws IOException {
        keywordDBService.processAndSaveData("existedData/keyword/완성 키워드.json");
    }
}