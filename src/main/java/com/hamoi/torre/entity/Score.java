package com.hamoi.torre.entity;

import jakarta.persistence.*;
import java.time.Duration;
import java.time.Instant;

@Entity
@Table(name = "tb_score")
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int nDisks;

    private int movesMade;

    private Instant begin;

    @Column(name = "endTime")
    private Instant end;

    private Long durationSeconds;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Score() {}

    @PrePersist
    @PreUpdate
    public void calculateDuration() {
        if (begin != null && end != null) {
            this.durationSeconds = Duration.between(begin, end).getSeconds();
        }
    }

    public Long getId() {
        return id;
    }

    public int getnDisks() {
        return nDisks;
    }

    public void setnDisks(int nDisks) {
        this.nDisks = nDisks;
    }

    public int getMovesMade() {
        return movesMade;
    }

    public void setMovesMade(int movesMade) {
        this.movesMade = movesMade;
    }

    public Instant getBegin() {
        return begin;
    }

    public void setBegin(Instant begin) {
        this.begin = begin;
    }

    public Instant getEnd() {
        return end;
    }

    public void setEnd(Instant end) {
        this.end = end;
    }

    public Long getDurationSeconds() {
        return durationSeconds;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

