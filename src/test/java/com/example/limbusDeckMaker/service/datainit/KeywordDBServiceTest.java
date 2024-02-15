package com.example.limbusDeckMaker.service.datainit;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class KeywordDBServiceTest {


    @Autowired
    private KeywordDBService keywordDBService;

    @Test
    void processAndSaveData() throws IOException {
        keywordDBService.processAndSaveData("existedData/keyword/완성 키워드.json");
        keywordDBService.processAndSaveData("existedData/keyword/추가 키워드.json");
    }
}