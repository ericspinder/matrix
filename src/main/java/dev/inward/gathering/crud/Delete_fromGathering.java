package dev.inward.gathering.crud;

import dev.inward.crud.Crudem;
import dev.inward.crud.DeleteRequest;
import dev.inward.crud.DeleteResponse;
import dev.inward.fact.Fact;
import dev.inward.morph.Morph;

public abstract class Delete_fromGathering<F extends Fact<F>, M extends Morph<?>, Q extends DeleteRequest<?>, R extends DeleteResponse<?>> extends Crudem<F, M, Q, R> {


}
