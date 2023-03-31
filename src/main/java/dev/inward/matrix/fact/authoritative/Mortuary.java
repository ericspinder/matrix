package dev.inward.matrix.fact.authoritative;

import java.util.Objects;
import java.util.function.BiConsumer;

public abstract class Mortuary<EXPIRE extends Comparable<EXPIRE>, B extends Library<EXPIRE, B>, M extends Mortuary<EXPIRE, B, M>> implements BiConsumer<EXPIRE, M> {

    protected final Library<>
    @Override
    public void accept(EXPIRE expire, M m) {

    }

    @Override
    public Mortuary<EXPIRE, B, M> andThen(BiConsumer<? super EXPIRE, ? super M> after) {
        Objects.requireNonNull(after);
        after.accept();

        return (expire, m) -> {
            accept(expire, m);
            after.accept(expire, m);
        };
    }
}
