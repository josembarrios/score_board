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

public class ScoreBoardInfoReceiverFacadeTest extends ScoreBoardCommonsTest{

    @Rule
    public TestName name = new TestName();

    @BeforeClass
    public static void init() {
        ScoreBoardCommonsTest.initApp();
    }

    @Test
    public void receive_new_match() {
        Optional<Match> match1Holder = scoreBoardInfoReceiverFacade.receiveNewMatch("Mexico", "Canada");
        assertTrue("The Match object could not be built to start the game", match1Holder.isPresent());

        Optional<Match> match2Holder = scoreBoardInfoReceiverFacade.receiveNewMatch(null, "Canada");
        assertFalse("The Match object has been constructed with one of the teams as null", match2Holder.isPresent());

        Optional<Match> match3Holder = scoreBoardInfoReceiverFacade.receiveNewMatch("Mexico", null);
        assertFalse("The Match object has been constructed with one of the teams as null", match3Holder.isPresent());

        Optional<Match> match4Holder = scoreBoardInfoReceiverFacade.receiveNewMatch(null, null);
        assertFalse("The Match object has been constructed with one of the teams as null", match4Holder.isPresent());
    }

    @Test
    public void receive_match_to_finish() {
        Optional<Match> match1Holder = scoreBoardInfoReceiverFacade.receiveMatchToFinish("Mexico", "Canada");
        assertTrue("The Match object could not be built to finish the game", match1Holder.isPresent());

        Optional<Match> match2Holder = scoreBoardInfoReceiverFacade.receiveMatchToFinish(null, "Canada");
        assertFalse("The Match object has been constructed with one of the teams as null", match2Holder.isPresent());

        Optional<Match> match3Holder = scoreBoardInfoReceiverFacade.receiveMatchToFinish("Mexico", null);
        assertFalse("The Match object has been constructed with one of the teams as null", match3Holder.isPresent());

        Optional<Match> match4Holder = scoreBoardInfoReceiverFacade.receiveMatchToFinish(null, null);
        assertFalse("The Match object has been constructed with one of the teams as null", match4Holder.isPresent());
    }

    @Test
    public void receive_match_update_score() {
        Optional<Match> match1Holder = scoreBoardInfoReceiverFacade.receiveMatchUpdateScore("Mexico", "Canada", 2, 0);
        assertTrue("The Match object could not be built to finish the game", match1Holder.isPresent());

        Optional<Match> match2Holder = scoreBoardInfoReceiverFacade.receiveMatchUpdateScore(null, "Canada", 2, 0);
        assertFalse("The Match object has been constructed with one of the teams as null", match2Holder.isPresent());

        Optional<Match> match3Holder = scoreBoardInfoReceiverFacade.receiveMatchUpdateScore("Mexico", null, 2, 0);
        assertFalse("The Match object has been constructed with one of the teams as null", match3Holder.isPresent());

        Optional<Match> match4Holder = scoreBoardInfoReceiverFacade.receiveMatchUpdateScore(null, null, 2, 0);
        assertFalse("The Match object has been constructed with one of the teams as null", match4Holder.isPresent());

        Optional<Match> match5Holder = scoreBoardInfoReceiverFacade.receiveMatchUpdateScore("Mexico", "Canada", -1, 0);
        assertFalse("The Match object has been constructed with one of the teams with negative score", match5Holder.isPresent());

        Optional<Match> match6Holder = scoreBoardInfoReceiverFacade.receiveMatchUpdateScore("Mexico", "Canada", 0, -1);
        assertFalse("The Match object has been constructed with one of the teams with negative score", match6Holder.isPresent());

        Optional<Match> match7Holder = scoreBoardInfoReceiverFacade.receiveMatchUpdateScore("Mexico", "Canada", 0, null);
        assertFalse("The Match object has been constructed with one of the teams with negative score", match7Holder.isPresent());
    }

    @Override
    public String getTestName() {
        return this.name.getMethodName();
    }
}