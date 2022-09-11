package com.github.josembarrios.junit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import com.github.josembarrios.model.Match;
import com.github.josembarrios.model.MatchScore;

public class ScoreBoardFacadeTest extends ScoreBoardCommonsTest{

    @Rule
    public TestName name = new TestName();

    @BeforeClass
    public static void init() {
        ScoreBoardCommonsTest.initApp();
    }

    @Test
    public void init_game() {
        Match match = new Match(teamMexico, teamCanada);
        scoreBoardFacade.initGame(match);

        Optional<Match> matchOptional = scoreBoardFacade.findMatch(match.getMatchKey());
        assertTrue("Match not started", matchOptional.isPresent());
    }

    @Test
    public void init_game_already_started() {
        init_game();
        Integer games = scoreBoardFacade.sortedGames().size();

        Match match = new Match(teamMexico, teamCanada);
        scoreBoardFacade.initGame(match);

        assertTrue("The game has been started, when it should not have been.", games == scoreBoardFacade.sortedGames().size());
    }

    @Test
    public void finish_game() {
        Match match = new Match(teamSpain, teamBrazil);
        scoreBoardFacade.initGame(match);

        Optional<Match> matchOptional = scoreBoardFacade.findMatch(match.getMatchKey());
        assertTrue("Match not started", matchOptional.isPresent());

        scoreBoardFacade.finishGame(match);
        matchOptional = scoreBoardFacade.findMatch(match.getMatchKey());
        assertFalse("Match not finished", matchOptional.isPresent());
    }

    @Test
    public void updateScore() {
        Match match = new Match(teamUruguay, teamItaly);
        scoreBoardFacade.initGame(match);
        Optional<Match> matchOptional = scoreBoardFacade.findMatch(match.getMatchKey());
        assertTrue("Match not started", matchOptional.isPresent());

        Match modifiedMatch = new Match(teamUruguay, teamItaly, MatchScore.of(0,1));
        scoreBoardFacade.updateScore(modifiedMatch);
        matchOptional = scoreBoardFacade.findMatch(modifiedMatch.getMatchKey());
        assertTrue("The scoreboard has not been updated", matchOptional.get().getNumberMatchScore() == 1);

        Match modifiedMatch2 = new Match(teamUruguay, teamItaly, MatchScore.of(0,0));
        scoreBoardFacade.updateScore(modifiedMatch2);
        matchOptional = scoreBoardFacade.findMatch(modifiedMatch2.getMatchKey());
        assertTrue("One of the teams has subtracted a goal on the scoreboard.", matchOptional.get().getNumberMatchScore() == 1);

        Match unknownMatch = new Match(teamArgentina, teamAustralia, MatchScore.of(1,1));
        scoreBoardFacade.updateScore(unknownMatch);
        matchOptional = scoreBoardFacade.findMatch(unknownMatch.getMatchKey());
        assertFalse("A game that had not been started has been updated.", matchOptional.isPresent());

    }

    @Override
    public String getTestName() {
        return this.name.getMethodName();
    }
}