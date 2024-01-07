package com.example.demo.Service;

import com.example.demo.domain.Ego;
import com.example.demo.domain.Sinner;
import com.example.demo.repository.EgoRepository;
import com.example.demo.repository.SinnerRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class SinnerServiceTest {

    @Autowired
    private SinnerService sinnerService;

    @Autowired
    private SinnerRepository sinnerRepository;

    @Autowired
    private EgoRepository egoRepository;


    @Test
    public void testProcessAndSaveData() throws IOException {
        String jsonFilePath = "C:\\Spring\\demo\\src\\main\\java\\com\\example\\demo\\util\\SinclairDataChange_10.json";
        sinnerService.processAndSaveData(jsonFilePath);


    }

}