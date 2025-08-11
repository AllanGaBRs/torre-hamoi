package com.hamoi.torre.controller;

import com.hamoi.torre.dto.ScoreDto;
import com.hamoi.torre.dto.ScoreInsertDto;
import com.hamoi.torre.dto.ScoreRankDto;
import com.hamoi.torre.service.ScoreService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/scores")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @GetMapping("/top10")
    public ResponseEntity<List<ScoreRankDto>> getTop10Scores() {
        List<ScoreRankDto> topScores = scoreService.getTop10Scores();
        if (topScores.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(topScores);
    }

    @PostMapping
    public ResponseEntity<ScoreDto> saveScore(@Valid @RequestBody ScoreInsertDto dto) {
        ScoreDto savedScore = scoreService.saveScore(dto);
        return ResponseEntity.ok(savedScore);
    }
}
