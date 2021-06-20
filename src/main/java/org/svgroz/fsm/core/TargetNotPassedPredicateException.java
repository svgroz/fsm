package org.svgroz.fsm.core;

import java.util.StringJoiner;

/**
 * @author Simon Grozovsky svgroz@outlook.com
 */
public class TargetNotPassedPredicateException extends FSMException {
    private final Object action;
    private final Object target;
    private final Object predicate;

    public TargetNotPassedPredicateException(final Object action, final Object target, final Object predicate) {
        this.action = action;
        this.target = target;
        this.predicate = predicate;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", TargetNotPassedPredicateException.class.getSimpleName() + "[", "]")
                .add("action=" + action)
                .add("target=" + target)
                .add("predicate=" + predicate)
                .toString();
    }
}
