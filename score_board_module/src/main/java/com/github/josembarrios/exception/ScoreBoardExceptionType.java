package com.github.josembarrios.exception;

public enum ScoreBoardExceptionType {

    GAME_ALREADY_STARTED("Game Already Started"),
    UNKNOWN_MATCH("Unknown match"),
    SCORE_ERROR("Score Error. Score lower than the existing one");

    private final String key;

    ScoreBoardExceptionType(final String key) {
        this.key = key;
    }

    public String getKey() {
        return this.key;
    }

}
