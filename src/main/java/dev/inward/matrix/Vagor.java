package dev.inward.matrix;

import dev.inward.matrix.director.library.Memory;
import dev.inward.matrix.fact.matter.Named;

public class Vagor extends Scheme<Vagor,Arena, Named> {

    public Vagor(String scheme) {
        super(scheme);
    }

    @Override
    public long initTotalSpace(Memory<Named> memory) {
        return 0;
    }
}
