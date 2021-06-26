package org.svgroz.fsm.core;

import java.util.function.Consumer;

/**
 * @author Simon Grozovsky svgroz@outlook.com
 */
@FunctionalInterface
public interface FSMPostProcessor<T> extends Consumer<T> {
    void postProcess(T target);

    @Override
    default void accept(T t) {
        postProcess(t);
    }
}
