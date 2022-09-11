package com.github.josembarrios.dao;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.github.josembarrios.exception.ScoreBoardException;
import com.github.josembarrios.exception.ScoreBoardExceptionType;
import com.github.josembarrios.model.Match;

public class ScoreBoardDaoImpl implements ScoreBoardDao {

    private static final Comparator<Match> MATCH_COMPARATOR = Comparator.comparing(Match::getNumberMatchScore)
            .thenComparing(Match::getStartDate).reversed();

    private Map<String, Match> boardGames;


    public ScoreBoardDaoImpl() {
        boardGames = new HashMap<>();
    }

    @Override
    public void initGame(Match match) throws ScoreBoardException {
        if(boardGames.containsKey(match.getMatchKey())){
            throw new ScoreBoardException(ScoreBoardExceptionType.GAME_ALREADY_STARTED.getKey(), match);
        }

        boardGames.put(match.getMatchKey(), match);
    }

    @Override
    public void finishGame(Match match) throws ScoreBoardException {
        if(!boardGames.containsKey(match.getMatchKey())){
            throw new ScoreBoardException(ScoreBoardExceptionType.UNKNOWN_MATCH.getKey(), match);
        }

        boardGames.remove(match.getMatchKey(), match);
    }

    @Override
    public void updateScore(Match updatedMatch) throws ScoreBoardException {
        Match startedMatch = boardGames.get(updatedMatch.getMatchKey());
        if (null == startedMatch) {
            throw new ScoreBoardException(ScoreBoardExceptionType.UNKNOWN_MATCH.getKey(), updatedMatch);
        } else if (checkLowerScore(startedMatch, updatedMatch)) {
            throw new ScoreBoardException(ScoreBoardExceptionType.SCORE_ERROR.getKey(), updatedMatch);
        }

        startedMatch.setMatchScore(updatedMatch.getMatchScore());
    }

    @Override
    public Optional<Match> findMatch(String matchKey) {
        return Optional.ofNullable(boardGames.get(matchKey));
    }

    @Override
    public List<Match> sortedGames() {
        return boardGames.values().stream()
                .sorted(MATCH_COMPARATOR)
                .collect(Collectors.toList());
    }

    @Override
    public void clearGames() {
        boardGames.clear();
    }


    private boolean checkLowerScore(Match startedMatch, Match updatedMatch) {
        return startedMatch.getMatchScore().getHomeTeamScore() > updatedMatch.getMatchScore().getHomeTeamScore() ||
                startedMatch.getMatchScore().getAwayTeamScore() > updatedMatch.getMatchScore().getAwayTeamScore();
    }

}
