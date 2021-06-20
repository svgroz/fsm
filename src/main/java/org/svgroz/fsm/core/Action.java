package org.svgroz.fsm.core;

public interface Action<T> {
    default T getPayload() {
        return null;
    }
}
