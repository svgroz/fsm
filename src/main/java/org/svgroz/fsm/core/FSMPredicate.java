package org.svgroz.fsm.core;

import java.util.function.BiPredicate;

/**
 * @author Simon Grozovsky svgroz@outlook.com
 */
@FunctionalInterface
public interface FSMPredicate<C, T> extends BiPredicate<C, T> {
    boolean isValid(C context, T target);

    default boolean isInvalid(C context, T target) {
        return !isValid(context, target);
    }

    @Override
    default boolean test(C c, T t) {
        return isValid(c, t);
    }
}
