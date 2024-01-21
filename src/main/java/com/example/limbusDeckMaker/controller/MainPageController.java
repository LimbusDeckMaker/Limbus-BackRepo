package com.example.limbusDeckMaker.controller;

import com.example.limbusDeckMaker.service.YouTubeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.GeneralSecurityException;

@RestController
@RequestMapping("/main")
public class MainPageController {

    @Autowired
    private YouTubeService youTubeService;

    @GetMapping("/youtube")
    public String getLatestVideo() {
        try {
            return youTubeService.getLatestVideoByChannel();
        } catch (GeneralSecurityException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
