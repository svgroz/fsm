package org.svgroz.fsm.core;

import java.util.StringJoiner;

/**
 * @author Simon Grozovsky svgroz@outlook.com
 */
public class TargetNotPassedPredicate extends FSMException {
    private final Object action;
    private final Object target;
    private final Object predicate;

    public TargetNotPassedPredicate(final Object action, final Object target, final Object predicate) {
        this.action = action;
        this.target = target;
        this.predicate = predicate;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", TargetNotPassedPredicate.class.getSimpleName() + "[", "]")
                .add("action=" + action)
                .add("target=" + target)
                .add("predicate=" + predicate)
                .toString();
    }
}
