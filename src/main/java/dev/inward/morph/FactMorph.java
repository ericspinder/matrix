package dev.inward.morph;

import dev.inward.crud.Crudem;
import dev.inward.fact.Fact;

import java.util.EnumMap;

public class FactMorph<F extends Fact<F>> extends Morph<F> {

    public FactMorph(EnumMap<Crudem.Operation, Crudem> crudemMap) {
        super(crudemMap);
    }
}
