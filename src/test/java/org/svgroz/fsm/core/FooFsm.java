package org.svgroz.fsm.core;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class FooFsm implements FSM<Foo> {
    private final Map<Class<? extends Action<?>>, BiFunction<?, Foo, Foo>> ctx = new HashMap<>();

    public FooFsm() {
        addTransition(FooFsmTest.F.class, (x, foo) -> { return foo; });
        addTransition(FooFsmTest.S.class, (x, foo) -> { return foo; });
    }

    private <C, A extends Action<C>> void addTransition(Class<? extends A> action, BiFunction<C, Foo, Foo> processor) {
        ctx.put(action, processor);
    }

    @Override
    public <C, A extends Action<C>> Foo transit(A action, Foo target) {
        BiFunction<C, Foo, Foo> transition = (BiFunction<C, Foo, Foo>) ctx.get(action.getClass());
        return transition.apply(action.payload(), target);
    }
}
