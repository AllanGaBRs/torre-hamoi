package com.hamoi.torre.repository;

import com.hamoi.torre.entity.Score;
import com.hamoi.torre.projections.ScoreSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long> {

    @Query(value = """
        SELECT u.name AS name, s.n_disks AS nDisks, s.moves_made AS movesMade, s.duration_seconds AS durationSeconds
        FROM tb_score s
        JOIN tb_user u ON s.user_id = u.id
        ORDER BY s.n_disks DESC, s.moves_made ASC, s.duration_seconds ASC
        LIMIT 10
    """, nativeQuery = true)
    List<ScoreSummary> findTop10Scores();


}
