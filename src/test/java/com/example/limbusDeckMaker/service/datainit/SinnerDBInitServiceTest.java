package com.example.limbusDeckMaker.service.datainit;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SinnerDBInitServiceTest {

    @Autowired
    private SinnerDBInitService sinnerDBInitService;


    @Test
    void sinnerInputTest(){
        sinnerDBInitService.InputSinner();
    }

}