package com.hamoi.torre.projections;

import java.time.Duration;

public interface ScoreSummary {
    String getUsername();
    int getNDisks();
    int getMovesMade();
    long getDuration();
}
