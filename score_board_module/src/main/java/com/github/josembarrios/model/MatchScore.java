package com.github.josembarrios.model;

import org.immutables.value.Value;

@Value.Immutable
public abstract class MatchScore {

    public static MatchScore of (Integer homeTeamScore, Integer awayTeamScore) {
        return ImmutableMatchScore.of(homeTeamScore, awayTeamScore);
    }

    @Value.Parameter
    public abstract Integer getHomeTeamScore();

    @Value.Parameter
    public abstract Integer getAwayTeamScore();

    public String toString() {
        return this.getHomeTeamScore().toString() + "-" + this.getAwayTeamScore();
    }

    public Integer getMatchScore() {
        return this.getHomeTeamScore() + this.getAwayTeamScore();
    }

}
