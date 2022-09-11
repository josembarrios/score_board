package com.github.josembarrios.utils;

import com.github.josembarrios.model.Match;
import com.github.josembarrios.model.MatchTeam;

public final class BoardUtils {

    private static final String SEPARATOR = "-";
    private static final String SEPARATOR_BLANK = " - ";
    private static final String BLANK = " ";
    private BoardUtils() {

    }

    public static String getMatchKey (MatchTeam team1, MatchTeam team2) {
        StringBuilder sb = new StringBuilder();
        sb.append(team1.getKey());
        sb.append(SEPARATOR);
        sb.append(team2.getKey());
        return sb.toString();
    }

    public static String getSummary (Match match) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(match.getMatchKey());
        sb.append("] ");
        sb.append(match.getHomeTeam().getName());
        sb.append(BLANK);
        sb.append(match.getMatchScore().getHomeTeamScore());
        sb.append(SEPARATOR_BLANK);
        sb.append(match.getAwayTeam().getName());
        sb.append(BLANK);
        sb.append(match.getMatchScore().getAwayTeamScore());
        return sb.toString();
    }
}
