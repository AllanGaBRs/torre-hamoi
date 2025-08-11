package com.hamoi.torre.service;

import com.hamoi.torre.dto.ScoreDto;
import com.hamoi.torre.dto.ScoreInsertDto;
import com.hamoi.torre.dto.ScoreRankDto;
import com.hamoi.torre.entity.Score;
import com.hamoi.torre.entity.User;
import com.hamoi.torre.projections.ScoreSummary;
import com.hamoi.torre.repository.ScoreRepository;
import com.hamoi.torre.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<ScoreRankDto> getTop10Scores() {
        List<ScoreSummary> scores = scoreRepository.findTop10Scores();
        System.out.println(scores.getFirst());
        return scores.stream()
                .map(s -> new ScoreRankDto(s.getName(), s.getNDisks(), s.getMovesMade(), s.getDurationSeconds() != null ? s.getDurationSeconds() : 0L))
                .toList();
    }

    @Transactional
    public ScoreDto saveScore(ScoreInsertDto dto) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        System.out.println("Auth principal class: " + auth.getPrincipal().getClass());
        System.out.println("Auth name: " + auth.getName());
        User user = userRepository.findByName(username)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Score newScore = new Score();
        newScore.setnDisks(dto.getnDisks());
        newScore.setMovesMade(dto.getMovesMade());
        newScore.setBegin(dto.getBegin());
        newScore.setEnd(dto.getEnd());
        newScore.setUser(user);

        newScore = scoreRepository.save(newScore);

        user.getScores().add(newScore);
        userRepository.save(user);

        return new ScoreDto(
                newScore.getId(),
                newScore.getnDisks(),
                newScore.getMovesMade(),
                newScore.getDurationSeconds(),
                newScore.getBegin(),
                newScore.getEnd(),
                user.getUsername()
        );
    }
}
