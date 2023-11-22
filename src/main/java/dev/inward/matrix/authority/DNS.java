package dev.inward.matrix.authority;

import dev.inward.matrix.Scheme;
import dev.inward.matrix.director.library.Memory;

public class DNS extends Scheme<DNS, Office> {


    public DNS() {
        super("dns");
    }

    @Override
    public long initTotalSpace(Memory memory) {
        return 0;
    }
}
