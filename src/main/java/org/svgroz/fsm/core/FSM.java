package org.svgroz.fsm.core;

/**
 * @author Simon Grozovsky svgroz@outlook.com
 */
public interface FSM<T> {
    <C, A extends Action<C>> T transit(A action, T target);
}
