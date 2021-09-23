package dev.inward.morph;

import dev.inward.crud.Crudem;
import dev.inward.gathering.Gathering;

import java.util.EnumMap;

public class GatheringMorph<G extends Gathering> extends Morph {

    public GatheringMorph(EnumMap<Crudem.Operation, Crudem> crudemMap) {
        super(crudemMap);
    }
}
