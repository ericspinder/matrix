package dev.inward.matrix;

import dev.inward.matrix.director.library.Memory;

public class Anima extends Scheme<Anima,Soul, Dogma.Ethereal.SuperEgo> {

    public Anima() {
        super("anima");
    }

    @Override
    public long initTotalSpace(Memory memory) {
        return 0;
    }

}
