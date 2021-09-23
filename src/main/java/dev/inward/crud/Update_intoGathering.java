package dev.inward.crud;

import dev.inward.fact.Fact;
import dev.inward.gathering.Gathering;
import dev.inward.morph.Morph;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public abstract class Update_intoGathering<F extends Fact<F>, G extends Gathering<?,?,?,?,?>, Q extends UpdateRequest<?>, R extends UpdateResponse<?>> extends Crudem<F, Gathering<?,?,?,?,?>, UpdateRequest_intoGathering<?>, UpdateResponse_intoGathering<?>>  {


}
