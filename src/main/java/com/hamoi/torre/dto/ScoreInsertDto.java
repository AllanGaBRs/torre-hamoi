package com.hamoi.torre.dto;

import java.time.Instant;

public class ScoreInsertDto {
    private int nDisks;
    private int movesMade;
    private Instant begin;
    private Instant end;

    public ScoreInsertDto() {}

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
}
