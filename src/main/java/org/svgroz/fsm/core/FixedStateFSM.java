package org.svgroz.fsm.core;

import java.util.Map;

/**
 * @author Simon Grozovsky svgroz@outlook.com
 */
public class FixedStateFSM<T> extends SimpleFSM<T> implements FSM<T> {
    public FixedStateFSM(
            final Map<Class<?>, Transition<?, T>> ctx
    ) {
        super(ctx);
    }
}
