package com.github.josembarrios.dao;

import java.util.List;
import java.util.Optional;

import com.github.josembarrios.exception.ScoreBoardException;
import com.github.josembarrios.model.Match;

public interface ScoreBoardDao {

    void initGame(Match match) throws ScoreBoardException;

    void finishGame(Match match) throws ScoreBoardException;

    void updateScore(Match updatedMatch) throws ScoreBoardException;

    Optional<Match> findMatch(String matchKey);

    List<Match> sortedGames();

    void clearGames();
}
