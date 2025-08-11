package com.hamoi.torre.dto;

import java.time.Instant;

public class ScoreDto {
    private Long id;
    private int nDisks;
    private int movesMade;
    private long durationSeconds;
    private Instant begin;
    private Instant end;
    private String userName;

    public ScoreDto() {}

    public ScoreDto(Long id, int nDisks, int movesMade, long durationSeconds, Instant begin, Instant end, String userName) {
        this.id = id;
        this.nDisks = nDisks;
        this.movesMade = movesMade;
        this.durationSeconds = durationSeconds;
        this.begin = begin;
        this.end = end;
        this.userName = userName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public long getDurationSeconds() {
        return durationSeconds;
    }

    public void setDurationSeconds(long durationSeconds) {
        this.durationSeconds = durationSeconds;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
