package com.hamoi.torre.dto;

public class ScoreRankDto {
    private String username;
    private int nDisks;
    private int movesMade;
    private long durationSeconds;

    public ScoreRankDto() {}

    public ScoreRankDto(String username, int nDisks, int movesMade, long durationSeconds) {
        this.username = username;
        this.nDisks = nDisks;
        this.movesMade = movesMade;
        this.durationSeconds = durationSeconds;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
}
