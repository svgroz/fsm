package org.svgroz.fsm.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author Simon Grozovsky svgroz@outlook.com
 */
public class FSMBuilderTest {
    @Test
    public void positiveScenarioTest() {
        FSMBuilder.<Foo>create()
                .addTransition(
                        FooActions.First.class,
                        (c, t) -> false,
                        (c, t) -> t
                )
                .addTransition(
                        FooActions.Second.class,
                        List.of((c, t) -> false),
                        (c, t) -> t
                )
                .addTransition(
                        FooActions.Third.class,
                        (c, t) -> t
                )
                .addTransition(
                        FooActions.Fourth.class,
                        (c, t) -> t,
                        (t) -> {
                        }
                )
                .addTransition(
                        FooActions.Fifth.class,
                        List.of((c, t) -> false),
                        (c, t) -> t,
                        List.of((t) -> { })
                )
                .build();

        FSMBuilder.<Foo>create()
                .addTransition(FooActions.First.class, (c, t) -> t)
                .addTransition(FooActions.Second.class, (c, t) -> t)
                .addTransition(FooActions.Third.class, (c, t) -> t)
                .build();
    }

    @Test
    public void throwsActionAlreadyRegisteredExceptionTest() {
        Assertions.assertThrows(ActionAlreadyRegisteredException.class,
                () -> {
                    FSMBuilder.<Foo>create()
                            .addTransition(FooActions.First.class, (c, t) -> t)
                            .addTransition(FooActions.Second.class, (c, t) -> t)
                            .addTransition(FooActions.Second.class, (c, t) -> t)
                            .build();
                }
        );
    }
}
