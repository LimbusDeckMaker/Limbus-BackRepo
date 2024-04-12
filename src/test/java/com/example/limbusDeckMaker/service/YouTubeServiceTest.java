package com.example.limbusDeckMaker.service;

import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.ResourceId;
import com.google.api.services.youtube.model.SearchListResponse;
import com.google.api.services.youtube.model.SearchResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class YouTubeServiceTest {

    @InjectMocks
    private YouTubeService youTubeService;


    @BeforeEach
    public void setup(){
        // YouTube API 호출 결과에 대한 모의 설정
        SearchListResponse mockResponse = new SearchListResponse();
        SearchResult mockSearchResult = new SearchResult();
        mockSearchResult.setId(new ResourceId().setVideoId("o04F1OEHxH8"));
        mockResponse.setItems(Collections.singletonList(mockSearchResult));

    }

    @Test
    public void getLatestVideoByChannel_ShouldReturnVideoId() throws Exception {
        // 메소드 호출
        String videoId = youTubeService.getLatestVideoByChannel();

        // 결과 검증
        assertThat(videoId).isEqualTo("o04F1OEHxH8");
    }
}