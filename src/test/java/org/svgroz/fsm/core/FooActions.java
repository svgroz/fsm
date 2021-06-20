package org.svgroz.fsm.core;

/**
 * @author Simon Grozovsky svgroz@outlook.com
 */
public final class FooActions {
    private FooActions() {

    }

    public static class First implements Action<Void> {

    }

    public static class Second implements Action<String> {
        @Override
        public String getPayload() {
            return Second.class.getSimpleName();
        }
    }

    public static class Third implements Action<Integer> {
        @Override
        public Integer getPayload() {
            return 2;
        }
    }

    public static class Fourth implements Action<Boolean> {
        @Override
        public Boolean getPayload() {
            return false;
        }
    }

    public static class Fifth implements Action<Boolean> {
        @Override
        public Boolean getPayload() {
            return false;
        }
    }
}
