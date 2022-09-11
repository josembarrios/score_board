package com.github.josembarrios.facade;

import java.util.Optional;

import com.github.josembarrios.model.Match;

/**
 * Raw data is received, validated and parsed to known types to the application
 */
public interface ScoreBoardInfoReceiverFacade {

    Optional<Match> receiveNewMatch (String homeTeam, String awayTeam);

    Optional<Match> receiveMatchToFinish (String homeTeam, String awayTeam);

    Optional<Match> receiveMatchUpdateScore(String homeTeam, String awayTeam, Integer homeTeamScore, Integer awayTeamScore);

}
