package dev.inward.matrix.morph;

import dev.inward.matrix.crud.Crudem;
import dev.inward.matrix.gathering.Gathering;

import java.util.EnumMap;

public class GatheringMorph<G extends Gathering<G,?,?>> extends Morph<G> {

    public GatheringMorph(EnumMap<Crudem.Operation, Crudem> crudemMap) {
        super(crudemMap);
    }
}
