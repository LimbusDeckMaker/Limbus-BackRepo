package com.example.limbusDeckMaker.controller;

import com.example.limbusDeckMaker.dto.steam.SteamNewsDto;
import com.example.limbusDeckMaker.service.SteamService;
import com.example.limbusDeckMaker.service.YouTubeService;
import com.example.limbusDeckMaker.util.Views;
import com.fasterxml.jackson.annotation.JsonView;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/main")
public class MainPageController {

    private final YouTubeService youTubeService;
    private final SteamService steamService;

    public MainPageController(YouTubeService youTubeService, SteamService steamService) {
        this.youTubeService = youTubeService;
        this.steamService = steamService;
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

    @JsonView(Views.Public.class)
    @GetMapping("/news")
    public ResponseEntity<List<SteamNewsDto>> getSteamNewsContent() {
        try {
            List<SteamNewsDto> steamNews = steamService.getNewsContent();

            if (!steamNews.isEmpty()) {
                return ResponseEntity.ok(steamNews);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
