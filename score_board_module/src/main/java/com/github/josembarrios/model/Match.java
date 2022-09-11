package com.github.josembarrios.model;

import java.time.Instant;

import com.github.josembarrios.utils.BoardUtils;


public class Match {

    private MatchTeam homeTeam;
    private MatchTeam awayTeam;
    private MatchScore matchScore;
    private Instant startDate;

    public Match (MatchTeam homeTeam, MatchTeam awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.initMatch();
    }

    public Match (MatchTeam homeTeam, MatchTeam awayTeam, MatchScore score) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.initMatch();
        this.matchScore = score;
    }

    public MatchTeam getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(MatchTeam homeTeam) {
        this.homeTeam = homeTeam;
    }

    public MatchTeam getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(MatchTeam awayTeam) {
        this.awayTeam = awayTeam;
    }

    public String getMatchKey() {
        return BoardUtils.getMatchKey(this.homeTeam,this.awayTeam);
    }

    public MatchScore getMatchScore() {
        return matchScore;
    }

    public void setMatchScore(MatchScore matchScore) {
        this.matchScore = matchScore;
    }

    public Instant getStartDate() {
        return startDate;
    }

    public Integer getNumberMatchScore() {
        return this.matchScore.getMatchScore();
    }

    private void initMatch() {
        this.matchScore = MatchScore.of(0,0);
        this.startDate = Instant.now();
    }

    @Override
    public String toString() {
        return "Match{" +
                "homeTeam=" + homeTeam +
                ", awayTeam=" + awayTeam +
                ", matchScore=" + matchScore +
                ", startDate=" + startDate +
                '}';
    }
}
