package dev.inward.gathering.crud;

import dev.inward.crud.Crudem;
import dev.inward.morph.Morph;

public class Read_fromGathering<V extends Comparable<V>, M extends Morph<?>> extends Crudem<V,M, ReadRequest_ofGathering<?>,ReadResponse_ofGathering<?>> {

    @Override
    public ReadResponse_ofGathering<?> fulfill(M morph, ReadRequest_ofGathering<?> request) {
        return null;
    }
}
