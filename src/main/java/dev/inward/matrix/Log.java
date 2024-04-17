package dev.inward.matrix;

import dev.inward.matrix.director.library.Memory;
import dev.inward.matrix.concept.matter.Indicia;


public abstract class Log extends Scheme<Log, Garner, Indicia> {

    public Log(String scheme) {
        super(scheme);
    }

    @Override
    public long initTotalSpace(Memory memory) {
        return 0;
    }

}
