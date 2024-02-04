package com.example.limbusDeckMaker.controller;

import com.example.limbusDeckMaker.domain.Board;
import com.example.limbusDeckMaker.repository.BoardRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notice")
public class BoardController {

    private final BoardRepository boardRepository;

    @Autowired
    public BoardController(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @GetMapping("")
    public ResponseEntity<List<Board>> getAllPost() {
        List<Board> posts = boardRepository.findAll();
        return ResponseEntity.ok(posts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Board> getSpecificPost(@PathVariable("id") Long id) {
        Optional<Board> post = boardRepository.findById(id);
        return post.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/latest")
    public ResponseEntity<Board> getLatestPost() {
        Board latestPost = boardRepository.findTopByOrderByDateDesc();
        return Optional.ofNullable(latestPost)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
