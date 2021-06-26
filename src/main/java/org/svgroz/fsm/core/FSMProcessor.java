package org.svgroz.fsm.core;

import java.util.function.BiFunction;

/**
 * @author Simon Grozovsky svgroz@outlook.com
 */
@FunctionalInterface
public interface FSMProcessor<C, T> extends BiFunction<C, T, T> {
    T process(C context, T target);

    @Override
    default T apply(C c, T t) {
        return process(c, t);
    }
}
