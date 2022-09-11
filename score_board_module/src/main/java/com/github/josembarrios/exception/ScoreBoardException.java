package com.github.josembarrios.exception;

import java.lang.reflect.Array;

public class ScoreBoardException extends Exception {

    private static final long serialVersionUID = 456590971443795716L;

    protected final String key;
    protected final transient Object[] args;

    public ScoreBoardException(final String key, final Object... args) {
        super(toString(key, args), null);
        this.key = key;
        this.args = args;
    }

    private static final String toString(final String key, final Object... args) {
        final StringBuilder sb = new StringBuilder(key);
        boolean first = true;

        for (final Object arg : args) {
            if (first) {
                sb.append(" : ");
                first = false;
            } else {
                sb.append(", ");
            }

            toString(sb, arg);
        }

        return sb.toString();
    }

    private static final void toString(final StringBuilder sb, final Object obj) {
        if (obj != null && obj.getClass().isArray()) {
            final int length = Array.getLength(obj);
            sb.append('[');

            for (int i = 0; i < length; i++) {
                if (i > 0) {
                    sb.append(';');
                }

                toString(sb, Array.get(obj, i));
            }

            sb.append(']');
        } else {
            sb.append(obj);
        }
    }

}
