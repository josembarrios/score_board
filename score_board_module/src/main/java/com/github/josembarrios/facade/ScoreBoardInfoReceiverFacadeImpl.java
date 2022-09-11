package com.github.josembarrios.facade;

import java.util.Optional;

import com.github.josembarrios.model.Match;
import com.github.josembarrios.model.MatchScore;
import com.github.josembarrios.model.MatchTeam;

public class ScoreBoardInfoReceiverFacadeImpl implements ScoreBoardInfoReceiverFacade {

    public ScoreBoardInfoReceiverFacadeImpl() {
        // Nothing to declare
    }

    @Override
    public Optional<Match> receiveNewMatch (String homeTeam, String awayTeam) {
        return validateAndBuildMatch(homeTeam, awayTeam);
    }

    @Override
    public Optional<Match> receiveMatchToFinish (String homeTeam, String awayTeam) {
        return validateAndBuildMatch(homeTeam, awayTeam);
    }

    @Override
    public Optional<Match> receiveMatchUpdateScore(String homeTeam, String awayTeam, Integer homeTeamScore, Integer awayTeamScore) {
        return validateAndBuildMatch(homeTeam, awayTeam, homeTeamScore, awayTeamScore);
    }

    private Optional<Match> validateAndBuildMatch (String homeTeam, String awayTeam) {
        return validateTeams(homeTeam, awayTeam) ? Optional.of(new Match(MatchTeam.of(homeTeam), MatchTeam.of(awayTeam))) : Optional.empty();
    }

    private Optional<Match> validateAndBuildMatch (String homeTeam, String awayTeam, Integer homeTeamScore, Integer awayTeamScore) {
        return (validateTeams(homeTeam, awayTeam) && validateScore(homeTeamScore, awayTeamScore)) ?
                Optional.of(new Match(MatchTeam.of(homeTeam), MatchTeam.of(awayTeam), MatchScore.of(homeTeamScore, awayTeamScore))) : Optional.empty();
    }

    private boolean validateTeams (String homeTeam, String awayTeam) {
        return (null != homeTeam && null != awayTeam);
    }

    private boolean validateScore (Integer homeTeamScore, Integer awayTeamScore) {
        return (null != homeTeamScore && null != awayTeamScore && homeTeamScore >= 0 && awayTeamScore >= 0);
    }
}
