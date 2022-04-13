package crud.morph;

import dev.inward.crud.Crudem;
import dev.inward.matrix.datum.fact.notion.Notion;

import java.util.EnumMap;

public class FactMorph<F extends Notion<F>> extends Morph<F> {

    public FactMorph(EnumMap<Crudem.Operation, Crudem> crudemMap) {
        super(crudemMap);
    }
}
