package com.example.limbusDeckMaker.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.limbusDeckMaker.domain.Board;
import com.example.limbusDeckMaker.repository.BoardRepository;
import java.util.Arrays;
import java.util.Date;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;


@WebMvcTest(BoardController.class)
class BoardControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BoardRepository boardRepository;


    @BeforeEach
    public void setup() {
        Board olderPost = Board.builder().id(1L).title("제목 1").content("테스트용입니다 1")
            .date(new Date(System.currentTimeMillis() - 100000)).build();

        Board latestPost = Board.builder().id(2L).title("제목 2").content("테스트용입니다 2")
            .date(new Date()).build();

        given(boardRepository.findAll()).willReturn(Arrays.asList(olderPost, latestPost));
        given(boardRepository.findById(1L)).willReturn(Optional.of(olderPost));
        given(boardRepository.findTopByOrderByDateDesc()).willReturn(latestPost);
    }

    @DisplayName("모든 게시글 조회")
    @Test
    void getAllPost() throws Exception {
        mockMvc.perform(get("/notice"))
            .andExpect(status().isOk())
            .andExpect(
                result -> assertThat(result.getResponse().getContentAsString().contains("제목 1")))
            .andExpect(
                result -> assertThat(result.getResponse().getContentAsString().contains("제목 2")));
    }

    @DisplayName("id로 특정 게시글 조회")
    @Test
    void getSpecificPost() throws Exception {
        mockMvc.perform(get("/notice/{id}", 1L))
            .andExpect(status().isOk())
            .andExpect(
                result -> assertThat(result.getResponse().getContentAsString().contains("제목1")));
    }

    @DisplayName("날짜 기준으로 가장 최신 게시글 조회")
    @Test
    void getLatestPost() throws Exception {
        mockMvc.perform(get("/notice/latest"))
            .andExpect(status().isOk())
            .andExpect(
                result -> assertThat(result.getResponse().getContentAsString().contains("제목2")));
    }
}