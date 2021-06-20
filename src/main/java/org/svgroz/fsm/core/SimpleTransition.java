package org.svgroz.fsm.core;

import java.util.List;
import java.util.StringJoiner;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

/**
 * @author Simon Grozovsky svgroz@outlook.com
 */
public class SimpleTransition<C, T> implements Transition<C, T> {
    private final List<BiPredicate<C, T>> predicates;
    private final List<BiFunction<C, T, T>> processors;
    private final List<Consumer<T>> postprocessors;

    public SimpleTransition(
            final List<BiPredicate<C, T>> predicates,
            final List<BiFunction<C, T, T>> processors,
            final List<Consumer<T>> postprocessors
    ) {
        this.predicates = predicates;
        this.processors = processors;
        this.postprocessors = postprocessors;
    }

    @Override
    public List<BiPredicate<C, T>> getPredicates() {
        return predicates;
    }

    @Override
    public List<BiFunction<C, T, T>> getProcessors() {
        return processors;
    }

    @Override
    public List<Consumer<T>> getPostprocessors() {
        return postprocessors;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SimpleTransition.class.getSimpleName() + "[", "]")
                .add("predicates=" + predicates)
                .add("processors=" + processors)
                .add("postprocessors=" + postprocessors)
                .toString();
    }
}
