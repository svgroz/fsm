package org.svgroz.fsm.core;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class FSMBuilder<T> {
    private final Map<Class<?>, BiFunction<?, T, T>> ctx = new HashMap<>();

    private FSMBuilder() {

    }

    public static <T> FSMBuilder<T> create() {
        return new FSMBuilder<>();
    }

    public <C, A extends Action<C>> FSMBuilder<T> addTransition(
            Class<? extends A> action,
            BiFunction<C, T, T> processor
    ) {
        ctx.put(action, processor);
        return this;
    }

    public FSM<T> build() {
        return new SimpleFSM<>(Map.copyOf(this.ctx));
    }
}
