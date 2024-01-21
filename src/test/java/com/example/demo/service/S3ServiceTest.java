package com.example.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class S3ServiceTest {

    @Autowired
    private S3Service s3Service;


    @Test
    public void testGetAllImageUrls() {
        List<String> urls = s3Service.getAllImageUrls();
        for(String url : urls){
            log.info("urls -> {}", url);
        }
    }
}