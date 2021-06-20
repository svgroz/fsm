package org.svgroz.fsm.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FooFsmTest {
    @Test
    public void basicTransitionsTest() {
        var foo = new Foo();

        var fooFsm = FSMBuilder.<Foo>create()
                .addTransition(
                        FooActions.First.class,
                        (action, target) -> {
                            target.setValue(0);
                            return target;
                        }
                )
                .addTransition(
                        FooActions.Second.class,
                        (c, t) -> c.equalsIgnoreCase("ssss"),
                        (action, target) -> {
                            target.setValue(target.getValue() + 1);
                            return target;
                        }
                )
                .addTransition(
                        FooActions.Third.class,
                        List.of((c, t) -> c != 2),
                        (action, target) -> {
                            target.setValue(target.getValue() + 1);
                            return target;
                        }
                )
                .build();

        foo = fooFsm.transit(new FooActions.First(), foo);
        Assertions.assertEquals(0, foo.getValue());

        fooFsm.transit(new FooActions.Second(), foo);
        Assertions.assertEquals(1, foo.getValue());

        fooFsm.transit(new FooActions.Third(), foo);
        Assertions.assertEquals(2, foo.getValue());
    }
}
