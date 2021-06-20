package org.svgroz.fsm.core;

import java.util.Objects;
import java.util.StringJoiner;

public class Foo {
    private Integer value;

    public Integer getValue() {
        return value;
    }

    public void setValue(final Integer value) {
        this.value = value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof final Foo foo)) return false;
        return Objects.equals(value, foo.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Foo.class.getSimpleName() + "[", "]")
                .add("value=" + value)
                .toString();
    }
}
