package com.example.limbusDeckMaker.service;

import com.example.limbusDeckMaker.dto.steam.SteamAPIResponse;
import com.example.limbusDeckMaker.dto.steam.SteamNewsDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Slf4j
@Service
public class SteamService {

    @Value("${steam.api.key}")
    private String steamWebAPIKey;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private static final String GET_NEWS_FOR_LIMBUS_URL = "https://api.steampowered.com/ISteamNews/GetNewsForApp/v0002/" +
            "?appid=1973530&count=3&maxlength=300&format=json ";


    public List<SteamNewsDto> getNewsInfo() throws IOException {
        URL steamNewsUrl = new URL(GET_NEWS_FOR_LIMBUS_URL);
        HttpURLConnection connection = (HttpURLConnection) steamNewsUrl.openConnection();
            connection.setRequestMethod("GET");

        SteamAPIResponse apiResponse = objectMapper.readValue(connection.getInputStream(), SteamAPIResponse.class);
        return apiResponse.getSteamAppNews().getNewsItems();
    }

    public Optional<SteamNewsDto> findSpecificNews(List<SteamNewsDto> steamNewsList, String titleKeyword, String contentKeyword){
        for(SteamNewsDto steamNews : steamNewsList){
            if(steamNews.getTitle().contains(titleKeyword) && steamNews.getContents().contains(contentKeyword)){
                return Optional.of(steamNews);
            }
        }
        return Optional.empty();
    }

    public String extractImageUrls(SteamNewsDto news) {
        String[] parts = news.getContents().split(" ");
        for (String part : parts) {
            if (part.startsWith("{STEAM_CLAN_IMAGE}")) {
                return part.replace("{STEAM_CLAN_IMAGE}", "https://clan.akamai.steamstatic.com/images/");
            }
        }
        return null;
    }

    public Date convertUnixDate(SteamNewsDto news){
        return new Date(news.getDate() * 1000L);
    }

    public List<SteamNewsDto> getNewsContent() throws IOException {
        List<SteamNewsDto> newsList = getNewsInfo();

        newsList.forEach(steamNewsDto -> {
            steamNewsDto.setImageUrl(extractImageUrls(steamNewsDto));
            steamNewsDto.setRelease(convertUnixDate(steamNewsDto));
        });

        return newsList;
    }

}
