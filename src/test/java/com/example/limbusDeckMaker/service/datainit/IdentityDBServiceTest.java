package com.example.limbusDeckMaker.service.datainit;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class IdentityDBServiceTest {

    @Autowired
    private IdentityDBService identityDBService;

    @Test
    void testProcessAndSaveData() throws IOException {
        identityDBService.processAndSaveData("existedData/identity/DonQuixoteData.json");
        identityDBService.processAndSaveData("existedData/identity/FaustData.json");
        identityDBService.processAndSaveData("existedData/identity/GregorData.json");
        identityDBService.processAndSaveData("existedData/identity/HeathcliffData.json");
        identityDBService.processAndSaveData("existedData/identity/HongLuData.json");
        identityDBService.processAndSaveData("existedData/identity/IshmaelData.json");
        identityDBService.processAndSaveData("existedData/identity/MeursaultData.json");
        identityDBService.processAndSaveData("existedData/identity/OutisData.json");
        identityDBService.processAndSaveData("existedData/identity/RodionData.json");
        identityDBService.processAndSaveData("existedData/identity/RyoShuData.json");
        identityDBService.processAndSaveData("existedData/identity/SinclairData.json");
        identityDBService.processAndSaveData("existedData/identity/YiSangData.json");
    }
}