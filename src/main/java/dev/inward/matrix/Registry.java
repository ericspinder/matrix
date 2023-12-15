package dev.inward.matrix;

import dev.inward.matrix.fact.datum.User;

import java.util.Map;
import java.util.concurrent.atomic.AtomicStampedReference;

public class Registry<S, L> {

    protected final L library;
    protected final Range<String> range;
    protected final Map<User<S,L,?>, AtomicStampedReference userMap>
}
