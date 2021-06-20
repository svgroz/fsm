package org.svgroz.fsm.core;

import java.util.StringJoiner;

/**
 * @author Simon Grozovsky svgroz@outlook.com
 */
public class ActionAlreadyRegistered extends FSMException {
    private final Class<?> action;
    private final Transition<?, ?> previousTransition;
    private final Transition<?, ?> newTransition;

    public ActionAlreadyRegistered(final Class<?> action, final Transition<?, ?> previousTransition, final Transition<?, ?> newTransition) {
        this.action = action;
        this.previousTransition = previousTransition;
        this.newTransition = newTransition;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ActionAlreadyRegistered.class.getSimpleName() + "[", "]")
                .add("action=" + action)
                .add("previousTransition=" + previousTransition)
                .add("newTransition=" + newTransition)
                .toString();
    }
}
