package dev.inward.datum;

import dev.inward.HouseKeeping;

public abstract class PrimitiveDatum<V extends Comparable<V>> extends Datum<V> {

    public PrimitiveDatum(HouseKeeping houseKeeping) {
        super(houseKeeping);
    }
}
