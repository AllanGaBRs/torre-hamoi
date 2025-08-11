package com.hamoi.torre.projections;

import java.time.Duration;

public interface ScoreSummary {
    String getName();
    int getNDisks();
    int getMovesMade();
    Long getDurationSeconds();
}
