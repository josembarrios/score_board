package com.github.josembarrios.facade;

import java.util.List;
import java.util.Optional;

import com.github.josembarrios.dao.ScoreBoardDao;
import com.github.josembarrios.dao.ScoreBoardDaoImpl;
import com.github.josembarrios.exception.ScoreBoardException;
import com.github.josembarrios.model.Match;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ScoreBoardFacadeImpl implements ScoreBoardFacade {

    private static Logger LOGGER = LoggerFactory.getLogger(ScoreBoardFacadeImpl.class);
    private ScoreBoardDao dao;

    public ScoreBoardFacadeImpl() {
        dao = new ScoreBoardDaoImpl();
    }

    @Override
    public void initGame(Match match) {
        try {
            this.dao.initGame(match);
        } catch (ScoreBoardException e) {
            LOGGER.error("An error occurred while starting the game: " + e.getMessage());
        }
    }

    @Override
    public void finishGame(Match match) {
        try {
            this.dao.finishGame(match);
        } catch (ScoreBoardException e) {
            LOGGER.error("An error occurred while finishing the game: " + e.getMessage());
        }
    }

    @Override
    public void updateScore(Match updatedMatch) {
        try {
            this.dao.updateScore(updatedMatch);
        } catch (ScoreBoardException e) {
            LOGGER.error("An error occurred updating the match result: " + e.getMessage());
        }
    }

    @Override
    public Optional<Match> findMatch(String matchKey) {
        return this.dao.findMatch(matchKey);
    }

    @Override
    public List<Match> sortedGames() {
        return this.dao.sortedGames();
    }

    @Override
    public void clearGames() {
        this.dao.clearGames();
    }

}
