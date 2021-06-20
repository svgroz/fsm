package org.svgroz.fsm.core;

import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

/**
 * @author Simon Grozovsky svgroz@outlook.com
 */
public interface Transition<C, T> {
    default List<BiPredicate<C, T>> getPredicates() {
        return Collections.emptyList();
    }

    default List<BiFunction<C, T, T>> getProcessors() {
        return Collections.emptyList();
    }

    default List<Consumer<T>> getPostprocessors() {
        return Collections.emptyList();
    }
}
