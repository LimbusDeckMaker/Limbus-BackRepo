package com.example.limbusDeckMaker.service.datainit;

import java.io.IOException;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class IdentityDBServiceTest {

    @Autowired
    private IdentityDBService identityDBService;


    @Test
    @Order(2)
    void testProcessAndSaveData() throws IOException {
        identityDBService.processAndSaveData("existedData/identity/RyoShuData.json");
    }
}