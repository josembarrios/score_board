package com.github.josembarrios.junit;

import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import com.github.josembarrios.model.Match;
import com.github.josembarrios.utils.BoardUtils;

public class ScoreBoardApplicationTest extends ScoreBoardCommonsTest{

    private static Logger LOGGER = LogManager.getLogger(ScoreBoardApplicationTest.class);

    @Rule
    public TestName name = new TestName();

    @BeforeClass
    public static void init() {
        ScoreBoardCommonsTest.initApp();
    }

    @Test
    public void testApp() {
        // Mexico - Canada: 0 - 5
        Optional<Match> match1Holder = scoreBoardInfoReceiverFacade.receiveNewMatch("Mexico", "Canada");
        assertTrue("Match not parsed", match1Holder.isPresent());
        if(match1Holder.isPresent()) {
            scoreBoardFacade.initGame(match1Holder.get());
        }
        match1Holder = scoreBoardInfoReceiverFacade.receiveMatchUpdateScore("Mexico", "Canada", 0,5);
        assertTrue("Match not parsed", match1Holder.isPresent());
        if(match1Holder.isPresent()) {
            scoreBoardFacade.updateScore(match1Holder.get());
        }

        // Spain - Brazil: 10 – 2
        Optional<Match> match2Holder = scoreBoardInfoReceiverFacade.receiveNewMatch("Spain", "Brazil");
        assertTrue("Match not parsed", match2Holder.isPresent());
        if(match2Holder.isPresent()) {
            scoreBoardFacade.initGame(match2Holder.get());
        }
        match2Holder = scoreBoardInfoReceiverFacade.receiveMatchUpdateScore("Spain", "Brazil", 10,2);
        assertTrue("Match not parsed", match2Holder.isPresent());
        if(match2Holder.isPresent()) {
            scoreBoardFacade.updateScore(match2Holder.get());
        }

        // Germany - France: 2 – 2
        Optional<Match> match3Holder = scoreBoardInfoReceiverFacade.receiveNewMatch("Germany", "France");
        assertTrue("Match not parsed", match3Holder.isPresent());
        if(match3Holder.isPresent()) {
            scoreBoardFacade.initGame(match3Holder.get());
        }
        match3Holder = scoreBoardInfoReceiverFacade.receiveMatchUpdateScore("Germany", "France", 2,2);
        assertTrue("Match not parsed", match3Holder.isPresent());
        if(match3Holder.isPresent()) {
            scoreBoardFacade.updateScore(match3Holder.get());
        }

        // Uruguay - Italy: 6 – 6
        Optional<Match> match4Holder = scoreBoardInfoReceiverFacade.receiveNewMatch("Uruguay", "Italy");
        assertTrue("Match not parsed", match4Holder.isPresent());
        if(match4Holder.isPresent()) {
            scoreBoardFacade.initGame(match4Holder.get());
        }
        match4Holder = scoreBoardInfoReceiverFacade.receiveMatchUpdateScore("Uruguay", "Italy", 6,6);
        assertTrue("Match not parsed", match4Holder.isPresent());
        if(match4Holder.isPresent()) {
            scoreBoardFacade.updateScore(match4Holder.get());
        }

        // Argentina - Australia: 3 - 1
        Optional<Match> match5Holder = scoreBoardInfoReceiverFacade.receiveNewMatch("Argentina", "Australia");
        assertTrue("Match not parsed", match5Holder.isPresent());
        if(match5Holder.isPresent()) {
            scoreBoardFacade.initGame(match5Holder.get());
        }
        match5Holder = scoreBoardInfoReceiverFacade.receiveMatchUpdateScore("Argentina", "Australia", 3,1);
        assertTrue("Match not parsed", match5Holder.isPresent());
        if(match5Holder.isPresent()) {
            scoreBoardFacade.updateScore(match5Holder.get());
        }

        for (Match match : scoreBoardFacade.sortedGames()) {
            LOGGER.debug(BoardUtils.getSummary(match));
        }

    }



    @Override
    public String getTestName() {
        return this.name.getMethodName();
    }
}