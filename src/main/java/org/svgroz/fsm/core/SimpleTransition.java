package org.svgroz.fsm.core;

import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

/**
 * @author Simon Grozovsky svgroz@outlook.com
 */
public class SimpleTransition<C, T> implements Transition<C, T> {
    private final List<FSMPredicate<C, T>> predicates;
    private final List<FSMProcessor<C, T>> processors;
    private final List<FSMPostProcessor<T>> postprocessors;

    public SimpleTransition(
            final List<FSMPredicate<C, T>> predicates,
            final List<FSMProcessor<C, T>> processors,
            final List<FSMPostProcessor<T>> postprocessors
    ) {
        this.predicates = predicates == null || predicates.isEmpty() ? Collections.emptyList() : List.copyOf(predicates);
        this.processors = processors == null || processors.isEmpty() ? Collections.emptyList() : List.copyOf(processors);
        this.postprocessors = postprocessors == null || postprocessors.isEmpty() ? Collections.emptyList() : List.copyOf(postprocessors);
    }

    @Override
    public List<FSMPredicate<C, T>> getPredicates() {
        return predicates;
    }

    @Override
    public List<FSMProcessor<C, T>> getProcessors() {
        return processors;
    }

    @Override
    public List<FSMPostProcessor<T>> getPostprocessors() {
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
