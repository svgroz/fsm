package org.svgroz.fsm.core;

/**
 * @author Simon Grozovsky svgroz@outlook.com
 */
public interface Action<T> {
    default T getPayload() {
        return null;
    }
}
