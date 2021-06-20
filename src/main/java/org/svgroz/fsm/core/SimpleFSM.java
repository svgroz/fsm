package org.svgroz.fsm.core;

import java.util.Map;

/**
 * @author Simon Grozovsky svgroz@outlook.com
 */
public class SimpleFSM<T> implements FSM<T> {
    private final Map<Class<?>, Transition<?, T>> ctx;

    public SimpleFSM(final Map<Class<?>, Transition<?, T>> ctx) {
        this.ctx = Map.copyOf(ctx);
    }

    @Override
    public <C, A extends Action<C>> T transit(A action, T target) {
        @SuppressWarnings("unchecked")
        var transition = (Transition<C, T>) ctx.get(action.getClass());
        for (var predicate : transition.getPredicates()) {
            if (predicate.test(action.getPayload(), target)) {
                throw new TargetNotPassedPredicateException(action, target, predicate);
            }
        }

        for (var processor : transition.getProcessors()) {
            target = processor.apply(action.getPayload(), target);
        }

        for (var postprocessor : transition.getPostprocessors()) {
            postprocessor.accept(target);
        }

        return target;
    }
}
