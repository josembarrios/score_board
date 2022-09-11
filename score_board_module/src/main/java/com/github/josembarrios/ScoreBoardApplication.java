package com.github.josembarrios;

import com.github.josembarrios.facade.ScoreBoardFacade;
import com.github.josembarrios.facade.ScoreBoardFacadeImpl;
import com.github.josembarrios.facade.ScoreBoardInfoReceiverFacade;
import com.github.josembarrios.facade.ScoreBoardInfoReceiverFacadeImpl;

public class ScoreBoardApplication {

    private ScoreBoardFacade scoreBoardFacade;
    private ScoreBoardInfoReceiverFacade scoreBoardInfoReceiverFacade;

    public ScoreBoardApplication() {
        this.scoreBoardFacade = new ScoreBoardFacadeImpl();
        this.scoreBoardInfoReceiverFacade = new ScoreBoardInfoReceiverFacadeImpl();
    }

    public ScoreBoardFacade getScoreBoardFacade() {
        return scoreBoardFacade;
    }

    public ScoreBoardInfoReceiverFacade getScoreBoardInfoReceiverFacade() {
        return scoreBoardInfoReceiverFacade;
    }

}
