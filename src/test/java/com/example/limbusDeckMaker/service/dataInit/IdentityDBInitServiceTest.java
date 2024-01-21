package com.example.limbusDeckMaker.service.dataInit;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class IdentityDBInitServiceTest {

    @Autowired
    private IdentityDBInitService identityDBInitService;

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
        String yiSangEgoPath = "src/main/resources/json/identity/YiSangData.json";
        String faustEgoPath = "src/main/resources/json/identity/FaustData.json";
        String donQuixoteEgoPath = "src/main/resources/json/identity/DonQuixoteData.json";
        String ryoShuEgoPath = "src/main/resources/json/identity/RyoShuData.json";
        String merusaultEgoPath = "src/main/resources/json/identity/MeursaultData.json";
        String hongLuEgoPath = "src/main/resources/json/identity/HongLuData.json";
        String heathcliffEgoPath = "src/main/resources/json/identity/HeathcliffData.json";
        String ishmaelEgoPath = "src/main/resources/json/identity/IshmaelData.json";
        String rodionEgoPath = "src/main/resources/json/identity/RodionData.json";
        String sinclairEgoPath = "src/main/resources/json/identity/SinclairData.json";
        String outisEgoPath = "src/main/resources/json/identity/OutisData.json";
        String gregorEgoPath = "src/main/resources/json/identity/GregorData.json";
        identityDBInitService.processAndSaveData(yiSangEgoPath);
        identityDBInitService.processAndSaveData(faustEgoPath);
        identityDBInitService.processAndSaveData(donQuixoteEgoPath);
        identityDBInitService.processAndSaveData(ryoShuEgoPath);
        identityDBInitService.processAndSaveData(merusaultEgoPath);
        identityDBInitService.processAndSaveData(hongLuEgoPath);
        identityDBInitService.processAndSaveData(heathcliffEgoPath);
        identityDBInitService.processAndSaveData(ishmaelEgoPath);
        identityDBInitService.processAndSaveData(rodionEgoPath);
        identityDBInitService.processAndSaveData(sinclairEgoPath);
        identityDBInitService.processAndSaveData(outisEgoPath);
        identityDBInitService.processAndSaveData(gregorEgoPath);
    }
}