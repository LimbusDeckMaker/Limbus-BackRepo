package com.example.limbusDeckMaker.service;

import com.example.limbusDeckMaker.dto.steam.SteamAPIResponse;
import com.example.limbusDeckMaker.dto.steam.SteamNewsDto;
import com.fasterxml.jackson.databind.ObjectMapper;
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
            "?appid=1973530&count=5&maxlength=300&format=json ";


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

    public List<String> extractImageUrls(SteamNewsDto news) {
        List<String> imageUrls = new ArrayList<>();
        String[] parts = news.getContents().split(" ");
        for (String part : parts) {
            if (part.startsWith("{STEAM_CLAN_IMAGE}")) {
                String imageUrl = part.replace("{STEAM_CLAN_IMAGE}", "https://clan.akamai.steamstatic.com/images/");
                imageUrls.add(imageUrl);
            }
        }
        return imageUrls;
    }

    public SteamNewsDto getNewsContent(String titleKeyword, String contentKeyword) throws IOException {
        List<SteamNewsDto> newsList = getNewsInfo();
        Optional<SteamNewsDto> specificNews = findSpecificNews(newsList, titleKeyword, contentKeyword);

        if (specificNews.isPresent()) {
            SteamNewsDto news = specificNews.get();
            List<String> imageUrls = extractImageUrls(news);
            news.setImageUrls(imageUrls);
            return news;
        } else {
            return new SteamNewsDto();
        }
    }

}
