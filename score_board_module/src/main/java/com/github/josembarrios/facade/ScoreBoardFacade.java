package com.github.josembarrios.facade;

import java.util.List;
import java.util.Optional;

import com.github.josembarrios.model.Match;

/**
 * Business logic to process the data received. Match operations (start, end and update).
 */
public interface ScoreBoardFacade {

    void initGame(Match match);

    void finishGame(Match match);

    void updateScore(Match updatedMatch);

    Optional<Match> findMatch(String matchKey);

    List<Match> sortedGames();

    void clearGames();

}
