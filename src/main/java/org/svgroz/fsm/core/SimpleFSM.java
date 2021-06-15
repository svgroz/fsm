package org.svgroz.fsm.core;

import java.util.Map;
import java.util.function.BiFunction;

public class SimpleFSM<T> implements FSM<T> {
    private final Map<Class<?>, BiFunction<?, T, T>> ctx;

    public SimpleFSM(final Map<Class<?>, BiFunction<?, T, T>> ctx) {
        this.ctx = Map.copyOf(ctx);
    }

    @Override
    public <C, A extends Action<C>> T transit(A action, T target) {
        @SuppressWarnings("unchecked")
        BiFunction<C, T, T> transition = (BiFunction<C, T, T>) ctx.get(action.getClass());
        return transition.apply(action.payload(), target);
    }
}
