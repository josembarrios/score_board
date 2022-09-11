package com.github.josembarrios.junit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;

import com.github.josembarrios.ScoreBoardApplication;
import com.github.josembarrios.exception.ScoreBoardException;
import com.github.josembarrios.facade.ScoreBoardFacade;
import com.github.josembarrios.facade.ScoreBoardInfoReceiverFacade;
import com.github.josembarrios.model.MatchTeam;


public abstract class ScoreBoardCommonsTest {

    protected static ScoreBoardApplication app;
    protected static ScoreBoardFacade scoreBoardFacade;
    protected static ScoreBoardInfoReceiverFacade scoreBoardInfoReceiverFacade;

    protected static MatchTeam teamMexico;
    protected static  MatchTeam teamCanada;
    protected static  MatchTeam teamSpain;
    protected static  MatchTeam teamBrazil;
    protected static  MatchTeam teamGermany;
    protected static  MatchTeam teamFrance;
    protected static  MatchTeam teamUruguay;
    protected static  MatchTeam teamItaly;
    protected static  MatchTeam teamArgentina;
    protected static  MatchTeam teamAustralia;

    private static Logger LOGGER = LogManager.getLogger(ScoreBoardCommonsTest.class);

    @Before
    public void startTest() throws ScoreBoardException {
        scoreBoardFacade.clearGames();
        LOGGER.debug("----------------------------------------------------------------------------------------------------------------------------------------");
        LOGGER.debug("-- INI TEST {} --" + getTestName());
        LOGGER.debug("----------------------------------------------------------------------------------------------------------------------------------------");
    }

    @After
    public void endTest() throws ScoreBoardException {
        LOGGER.debug("----------------------------------------------------------------------------------------------------------------------------------------");
        LOGGER.debug("-- FIN TEST {} --" + getTestName());
        LOGGER.debug("----------------------------------------------------------------------------------------------------------------------------------------");
    }

    public static void initApp() {
        LOGGER.debug("----------------------------------------------------------------------------------------------------------------------------------------");
        LOGGER.debug("-- INI LAUNCH de la aplicacion");
        LOGGER.debug("----------------------------------------------------------------------------------------------------------------------------------------");

        app = new ScoreBoardApplication();
        scoreBoardFacade = app.getScoreBoardFacade();
        scoreBoardInfoReceiverFacade = app.getScoreBoardInfoReceiverFacade();

        teamMexico = MatchTeam.of("Mexico");
        teamCanada = MatchTeam.of("Canada");
        teamBrazil = MatchTeam.of("Brazil");
        teamSpain = MatchTeam.of("Spain");
        teamGermany = MatchTeam.of("Germany");
        teamFrance = MatchTeam.of("France");
        teamUruguay = MatchTeam.of("Uruguay");
        teamItaly = MatchTeam.of("Italy");
        teamArgentina = MatchTeam.of("Argentina");
        teamAustralia = MatchTeam.of("Australia");

        LOGGER.debug("----------------------------------------------------------------------------------------------------------------------------------------");
        LOGGER.debug("-- FIN LAUNCH de la aplicacion");
        LOGGER.debug("----------------------------------------------------------------------------------------------------------------------------------------");
    }

    public abstract String getTestName();

}
