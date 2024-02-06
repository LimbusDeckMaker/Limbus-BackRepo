package com.example.limbusDeckMaker.service.datainit;

import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class S3ServiceTest {

    @Autowired
    private S3Service s3Service;


    @Test
    public void testGetAllImageUrls() {
        s3Service.processS3ObjectAndDBMapping();
    }

    @Test
    public void testNewDataInput() throws IOException {
        s3Service.awsS3NewIdentityDataDBInput("2024-02-06");
    }
}