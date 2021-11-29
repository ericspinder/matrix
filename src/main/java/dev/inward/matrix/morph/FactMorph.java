package dev.inward.matrix.morph;

import dev.inward.matrix.crud.Crudem;
import dev.inward.matrix.fact.Fact;

import java.util.EnumMap;

public class FactMorph<F extends Fact<F>> extends Morph<F> {

    public FactMorph(EnumMap<Crudem.Operation, Crudem> crudemMap) {
        super(crudemMap);
    }
}
