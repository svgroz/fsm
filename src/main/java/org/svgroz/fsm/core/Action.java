package org.svgroz.fsm.core;

public interface Action<T> {
    default T payload() {
        return null;
    }
}
