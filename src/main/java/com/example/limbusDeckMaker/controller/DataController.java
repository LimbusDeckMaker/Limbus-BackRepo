package com.example.limbusDeckMaker.controller;

import com.example.limbusDeckMaker.service.datainit.S3Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/data")
public class DataController {

    private final S3Service s3Service;

    public DataController(S3Service s3Service) {
        this.s3Service = s3Service;
    }

    @GetMapping("/ego/{date}")
    public ResponseEntity<String> processEgoData(@PathVariable String date) {
        try {
            s3Service.awsS3NewEgoDataDBInput(date);
            return ResponseEntity.ok("Ego data processed successfully for date: " + date);
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error processing ego data: " + e.getMessage());
        }
    }

    @GetMapping("/identity/{date}")
    public ResponseEntity<String> processIdentityData(@PathVariable String date) {
        try {
            s3Service.awsS3NewIdentityDataDBInput(date);
            return ResponseEntity.ok("Identity data processed successfully for date: " + date);
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error processing identity data: " + e.getMessage());
        }
    }
}
