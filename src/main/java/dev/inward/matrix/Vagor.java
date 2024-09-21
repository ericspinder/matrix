package dev.inward.matrix;

import dev.inward.matrix.fact.matter.Named;
import dev.inward.matrix.memory.Memory;

public class Vagor extends Scheme<Vagor,Arena, Named> {

    public Vagor(String scheme) {
        super(scheme);
    }

    @Override
    public long initTotalSpace(Memory<Named> memory) {
        return 0;
    }
}
