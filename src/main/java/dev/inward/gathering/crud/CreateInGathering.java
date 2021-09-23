package dev.inward.gathering.crud;

import dev.inward.crud.Crudem;
import dev.inward.fact.Fact;
import dev.inward.morph.Morph;

import java.lang.reflect.Constructor;

public class CreateInGathering<F extends Fact<F>, M extends Morph<?>, Q extends CreateRequest_inGathering<?>,  R extends CreateResponse_inGathering<?>> extends Crudem<F, M, Q, R> {

    protected Constructor<F> constructor;


    @Override
    public R fulfill(M morph, Q request) {
        return null;
    }
}
