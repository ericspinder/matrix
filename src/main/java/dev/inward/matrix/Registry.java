package dev.inward.matrix;

import java.util.Map;
import java.util.concurrent.atomic.AtomicStampedReference;

public class Registry<S, L> {

    protected final L library;
    protected final Range<String> range;
    protected final Map<Dogma<S,L,?>, AtomicStampedReference userMap>
}
