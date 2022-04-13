package crud.morph;

import dev.inward.matrix.Addressable;
import dev.inward.crud.Crudem;

import java.io.Serializable;
import java.util.EnumMap;

public abstract class Morph<UM extends Addressable<UM>> implements Serializable {

    protected final EnumMap<Crudem.Operation, Crudem> crudemMap;

    protected UM datum;

    public Morph(EnumMap<Crudem.Operation, Crudem> crudemMap) {
        this.crudemMap = crudemMap;
    }

}
