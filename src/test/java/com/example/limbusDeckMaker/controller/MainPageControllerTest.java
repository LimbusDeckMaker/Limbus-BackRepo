package com.example.limbusDeckMaker.controller;

import com.example.limbusDeckMaker.service.YouTubeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;
import java.security.GeneralSecurityException;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(MainPageController.class)
class MainPageControllerTest {

    @MockBean
    private YouTubeService youTubeService;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() throws GeneralSecurityException, IOException {
        String mockVideoId = "o04F1OEHxH8"; // Mock 검색 결과
        when(youTubeService.getLatestVideoByChannel()).thenReturn(mockVideoId);
    }

    @DisplayName("특정 채널의 최신 동영상 조회 성공")
    @Test
    public void getLatestVideo_ShouldReturnVideo() throws Exception {
        mockMvc.perform(get("/main/youtube"))
                .andExpect(status().isOk());
    }
}