package com.example.limbusDeckMaker.service.datainit;

import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class EgoDBServiceTest {

    @Autowired
    private EgoDBService egoDBService;


    @Test
    public void testProcessAndSaveData() throws IOException {

        egoDBService.processAndSaveData("existedData/ego/FaustData.json");

    }

}