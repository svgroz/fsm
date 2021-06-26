package org.svgroz.fsm.core;

import java.util.Collections;
import java.util.List;

/**
 * @author Simon Grozovsky svgroz@outlook.com
 */
public interface Transition<C, T> {
    default List<FSMPredicate<C, T>> getPredicates() {
        return Collections.emptyList();
    }

    default List<FSMProcessor<C, T>> getProcessors() {
        return Collections.emptyList();
    }

    default List<FSMPostProcessor<T>> getPostprocessors() {
        return Collections.emptyList();
    }
}
