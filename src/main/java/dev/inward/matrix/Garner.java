package dev.inward.matrix;

import dev.inward.matrix.director.library.Memory;
import dev.inward.matrix.director.library.catalog.Catalog;
import dev.inward.matrix.director.library.catalog.Gathering;
import dev.inward.matrix.fact.Fact;
import dev.inward.matrix.fact.authoritative.notion.Notion;
import dev.inward.matrix.fact.matter.Indicia;

public class Garner extends Library<Log,Garner, Indicia> {
    @Override
    protected <ID extends Comparable<ID>, Q extends Query<Log, Garner, Indicia, ID, Q>, D extends Gathering<Log, Garner, Indicia, D, O, F>, O extends Notion<Log, Garner, Indicia, O>, N extends Identity.Tangible.Named<Log, Garner, Indicia, N, F>, F extends Fact<Log, Garner, Indicia, N, F>> Catalog<Log, Garner, Indicia, D, O, N> initCatalog(Library<Log, Garner, Indicia> library, Memory<Log, Garner> memory, Identity.Ethereal<Log, Garner, Indicia, ID, Q> ethereal) throws CheckedException {
        return null;
    }

    @Override
    public int compareTo(Garner o) {
        return 0;
    }
}
