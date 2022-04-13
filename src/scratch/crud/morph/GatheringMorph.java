package crud.morph;

import dev.inward.crud.Crudem;

import java.util.EnumMap;

public class GatheringMorph<G> extends Morph<G> {

    public GatheringMorph(EnumMap<Crudem.Operation, Crudem> crudemMap) {
        super(crudemMap);
    }
}
