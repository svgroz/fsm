package org.svgroz.fsm.core;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

public class FSMBuilder<T> {
    private final Map<Class<?>, Transition<?, T>> ctx = new HashMap<>();

    private FSMBuilder() {

    }

    public static <T> FSMBuilder<T> create() {
        return new FSMBuilder<>();
    }

    public <C, A extends Action<C>> FSMBuilder<T> addTransition(
            Class<? extends A> action,
            BiPredicate<C, T> predicate,
            BiFunction<C, T, T> processor
    ) {
        return addTransition(action, List.of(predicate), processor);
    }

    public <C, A extends Action<C>> FSMBuilder<T> addTransition(
            Class<? extends A> action,
            List<BiPredicate<C, T>> predicates,
            BiFunction<C, T, T> processor
    ) {
        var newTransition = new SimpleTransition<>(List.copyOf(predicates), List.of(processor), Collections.emptyList());
        var previousTransition = ctx.put(action, newTransition);
        if (previousTransition == null) {
            return this;
        } else {
            throw new ActionAlreadyRegisteredException(action, previousTransition, newTransition);
        }
    }

    public <C, A extends Action<C>> FSMBuilder<T> addTransition(
            Class<? extends A> action,
            BiFunction<C, T, T> processor
    ) {
        var newTransition = new SimpleTransition<>(List.of(), List.of(processor), List.of());
        var previousTransition = ctx.put(action, newTransition);
        if (previousTransition == null) {
            return this;
        } else {
            throw new ActionAlreadyRegisteredException(action, previousTransition, newTransition);
        }
    }

    public <C, A extends Action<C>> FSMBuilder<T> addTransition(
            Class<? extends A> action,
            List<BiPredicate<C, T>> predicates,
            BiFunction<C, T, T> processor,
            List<Consumer<T>> postprocessors
    ) {
        var newTransition = new SimpleTransition<>(List.copyOf(predicates), List.of(processor), List.copyOf(postprocessors));
        var previousTransition = ctx.put(action, newTransition);
        if (previousTransition == null) {
            return this;
        } else {
            throw new ActionAlreadyRegisteredException(action, previousTransition, newTransition);
        }
    }

    public FSM<T> build() {
        return new SimpleFSM<>(Map.copyOf(this.ctx));
    }
}
