package com.example.demo.Service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class IdentityDBInsertServiceTest {

    @Autowired
    private IdentityDBInsertService identityDBInsertService;

    @Test
    void testProcessAndSaveData() throws IOException {
        String jsonFilePath = "src/main/java/com/example/demo/json/identity/SinclairData_10.json";
        identityDBInsertService.processAndSaveData(jsonFilePath);
    }
}