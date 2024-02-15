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

        egoDBService.processAndSaveData("existedData/ego/DonQuixoteData.json");
        egoDBService.processAndSaveData("existedData/ego/FaustData.json");
        egoDBService.processAndSaveData("existedData/ego/GregorData.json");
        egoDBService.processAndSaveData("existedData/ego/HeathcliffData.json");
        egoDBService.processAndSaveData("existedData/ego/HongLuData.json");
        egoDBService.processAndSaveData("existedData/ego/IshmaelData.json");
        egoDBService.processAndSaveData("existedData/ego/MeursaultData.json");
        egoDBService.processAndSaveData("existedData/ego/OutisData.json");
        egoDBService.processAndSaveData("existedData/ego/RodionData.json");
        egoDBService.processAndSaveData("existedData/ego/RyoShuData.json");
        egoDBService.processAndSaveData("existedData/ego/SinclairData.json");
        egoDBService.processAndSaveData("existedData/ego/YiSangData.json");

    }

}
