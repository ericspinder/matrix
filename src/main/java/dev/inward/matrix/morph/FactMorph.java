package dev.inward.matrix.morph;

import dev.inward.matrix.crud.Crudem;
import com.notionds.dataSupplier.datum.fact.notion.Notion;

import java.util.EnumMap;

public class FactMorph<F extends Notion<F>> extends Morph<F> {

    public FactMorph(EnumMap<Crudem.Operation, Crudem> crudemMap) {
        super(crudemMap);
    }
}
