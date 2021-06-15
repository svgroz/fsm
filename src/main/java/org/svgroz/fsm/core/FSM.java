package org.svgroz.fsm.core;

public interface FSM<T> {
    <C, A extends Action<C>> T transit(A action, T target);
}
