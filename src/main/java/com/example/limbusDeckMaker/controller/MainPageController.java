package com.example.limbusDeckMaker.controller;

import com.example.limbusDeckMaker.service.YouTubeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.GeneralSecurityException;

@RestController
@RequestMapping("/main")
public class MainPageController {

    private final YouTubeService youTubeService;

    public MainPageController(YouTubeService youTubeService) {
        this.youTubeService = youTubeService;
    }

    @GetMapping("/youtube")
    public ResponseEntity<String> getLatestVideo() {
        try {
            String videoId = youTubeService.getLatestVideoByChannel();

            String jsonResponse = "{\"videoId\": \"" + videoId + "\"}";
            return ResponseEntity.ok(jsonResponse);

        } catch (GeneralSecurityException | IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("An error occurred.");
        }
    }
}
