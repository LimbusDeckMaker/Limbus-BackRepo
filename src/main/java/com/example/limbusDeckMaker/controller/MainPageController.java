package com.example.limbusDeckMaker.controller;

import com.example.limbusDeckMaker.dto.steam.SteamNewsDto;
import com.example.limbusDeckMaker.service.SteamService;
import com.example.limbusDeckMaker.service.YouTubeService;
import com.example.limbusDeckMaker.util.Views;
import com.fasterxml.jackson.annotation.JsonView;
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
    @GetMapping("/contents")
    public ResponseEntity<SteamNewsDto> getSteamNewsContent() {
        try {
            String titleKeyword = "New Target Extraction";
            String contentKeyword = "{STEAM_CLAN_IMAGE}";

            SteamNewsDto steamNewsContent = steamService.getNewsContent(titleKeyword, contentKeyword);

            if (steamNewsContent != null && steamNewsContent.getUrl() != null) {
                return ResponseEntity.ok(steamNewsContent);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }
}
