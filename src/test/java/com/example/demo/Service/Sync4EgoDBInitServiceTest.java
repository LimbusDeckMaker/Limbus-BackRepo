package com.example.demo.Service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@Slf4j
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class Sync4EgoDBInitServiceTest {

    @Autowired
    private Sync4EgoDBInitService sync4EgoDBInitService;

    @Autowired
    private SinnerDBInitService sinnerDBInitService;


    @Test
    @Order(1)
    public void testInputSinner(){
        sinnerDBInitService.InputSinner();
    }


    @Test
    @Order(2)
    public void testProcessAndSaveData() throws IOException {

        String yiSangEgoPath = "src/main/java/com/example/demo/json/ego/YiSangData.json";
        String faustEgoPath = "src/main/java/com/example/demo/json/ego/FaustData.json";
        String donQuixoteEgoPath = "src/main/java/com/example/demo/json/ego/DonQuixoteData.json";
        String ryoShuEgoPath = "src/main/java/com/example/demo/json/ego/RyoShuData.json";
        String merusaultEgoPath = "src/main/java/com/example/demo/json/ego/MeursaultData.json";
        String hongLuEgoPath = "src/main/java/com/example/demo/json/ego/HongLuData.json";
        String heathcliffEgoPath = "src/main/java/com/example/demo/json/ego/HeathcliffData.json";
        String ishmaelEgoPath = "src/main/java/com/example/demo/json/ego/IshmaelData.json";
        String rodionEgoPath = "src/main/java/com/example/demo/json/ego/RodionData.json";
        String sinclairEgoPath = "src/main/java/com/example/demo/json/ego/SinclairData.json";
        String outisEgoPath = "src/main/java/com/example/demo/json/ego/OutisData.json";
        String gregorEgoPath = "src/main/java/com/example/demo/json/ego/GregorData.json";

        sync4EgoDBInitService.processAndSaveData(yiSangEgoPath);
        sync4EgoDBInitService.processAndSaveData(faustEgoPath);
        sync4EgoDBInitService.processAndSaveData(donQuixoteEgoPath);
        sync4EgoDBInitService.processAndSaveData(ryoShuEgoPath);
        sync4EgoDBInitService.processAndSaveData(merusaultEgoPath);
        sync4EgoDBInitService.processAndSaveData(hongLuEgoPath);
        sync4EgoDBInitService.processAndSaveData(heathcliffEgoPath);
        sync4EgoDBInitService.processAndSaveData(ishmaelEgoPath);
        sync4EgoDBInitService.processAndSaveData(rodionEgoPath);
        sync4EgoDBInitService.processAndSaveData(sinclairEgoPath);
        sync4EgoDBInitService.processAndSaveData(outisEgoPath);
        sync4EgoDBInitService.processAndSaveData(gregorEgoPath);
    }

}