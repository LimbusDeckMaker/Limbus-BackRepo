package com.example.demo.Service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@Slf4j
@SpringBootTest(classes = SinnerServiceTest.class)
class SinnerServiceTest {

    @Autowired
    private SinnerService sinnerService;



    @Test
    public void testProcessAndSaveData() throws IOException {
        String jsonFilePath = "C:\\Spring\\LimbusDeckMaker\\src\\main\\java\\com\\example\\demo\\json\\ego\\SinclairDataChange_10.json";
        sinnerService.processAndSaveData(jsonFilePath);


    }

}