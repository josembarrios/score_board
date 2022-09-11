package com.github.josembarrios.model;

import org.immutables.value.Value;

@Value.Immutable
public abstract class MatchTeam {

    public static MatchTeam of (String name) {
        return ImmutableMatchTeam.of(name);
    }

    @Value.Parameter
    public abstract String getName();

    public String getKey() {
        return this.getName().toUpperCase().substring(0,3);
    }

}
