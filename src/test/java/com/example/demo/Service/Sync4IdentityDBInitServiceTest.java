package com.example.demo.Service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class Sync4IdentityDBInitServiceTest {

    @Autowired
    private Sync4IdentityDBInitService sync4IdentityDBInitService;

    @Autowired
    private SinnerDBInitService sinnerDBInitService;

    @Test
    @Order(1)
    public void testInputSinner(){
        sinnerDBInitService.InputSinner();

    }


    @Test
    @Order(2)
    void testProcessAndSaveData() throws IOException {
        String yiSangEgoPath = "src/main/java/com/example/demo/json/identity/YiSangData.json";
        String faustEgoPath = "src/main/java/com/example/demo/json/identity/FaustData.json";
        String donQuixoteEgoPath = "src/main/java/com/example/demo/json/identity/DonQuixoteData.json";
        String ryoShuEgoPath = "src/main/java/com/example/demo/json/identity/RyoShuData.json";
        String merusaultEgoPath = "src/main/java/com/example/demo/json/identity/MeursaultData.json";
        String hongLuEgoPath = "src/main/java/com/example/demo/json/identity/HongLuData.json";
        String heathcliffEgoPath = "src/main/java/com/example/demo/json/identity/HeathcliffData.json";
        String ishmaelEgoPath = "src/main/java/com/example/demo/json/identity/IshmaelData.json";
        String rodionEgoPath = "src/main/java/com/example/demo/json/identity/RodionData.json";
        String sinclairEgoPath = "src/main/java/com/example/demo/json/identity/SinclairData.json";
        String outisEgoPath = "src/main/java/com/example/demo/json/identity/OutisData.json";
        String gregorEgoPath = "src/main/java/com/example/demo/json/identity/GregorData.json";
        sync4IdentityDBInitService.processAndSaveData(yiSangEgoPath);
        sync4IdentityDBInitService.processAndSaveData(faustEgoPath);
        sync4IdentityDBInitService.processAndSaveData(donQuixoteEgoPath);
        sync4IdentityDBInitService.processAndSaveData(ryoShuEgoPath);
        sync4IdentityDBInitService.processAndSaveData(merusaultEgoPath);
        sync4IdentityDBInitService.processAndSaveData(hongLuEgoPath);
        sync4IdentityDBInitService.processAndSaveData(heathcliffEgoPath);
        sync4IdentityDBInitService.processAndSaveData(ishmaelEgoPath);
        sync4IdentityDBInitService.processAndSaveData(rodionEgoPath);
        sync4IdentityDBInitService.processAndSaveData(sinclairEgoPath);
        sync4IdentityDBInitService.processAndSaveData(outisEgoPath);
        sync4IdentityDBInitService.processAndSaveData(gregorEgoPath);
    }
}