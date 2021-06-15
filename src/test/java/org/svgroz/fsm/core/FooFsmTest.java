package org.svgroz.fsm.core;

import org.junit.jupiter.api.Test;

public class FooFsmTest {
    public static class F implements Action<Void> {
        @Override
        public String toString() {
            return "F{}";
        }
    }

    public static class S implements Action<String> {
        private final String payload = "SSSS";

        @Override
        public String payload() {
            return payload;
        }

        @Override
        public String toString() {
            return "S{" +
                    "payload='" + payload + '\'' +
                    '}';
        }
    }

    @Test
    public void test1() {
        var foo = new Foo();
        var fooFsm = new FooFsm();
        fooFsm.transit(new F(), foo);
        fooFsm.transit(new S(), foo);
    }
}
