package dev.inward.matrix;

import dev.inward.matrix.authority.Domain;
import dev.inward.matrix.concept.matter.Matter;
import dev.inward.matrix.director.library.Memory;
import dev.inward.matrix.director.library.catalog.Catalog;
import dev.inward.matrix.director.library.catalog.Gathering;
import dev.inward.matrix.fact.Concept;
import dev.inward.matrix.fact.Fact;
import dev.inward.matrix.fact.authoritative.notion.Notion;
import dev.inward.matrix.concept.matter.Indicia;

import java.util.Map;
import java.util.regex.Pattern;

public class Garner extends Library<Log,Garner> {

    public Garner(Log scheme, Terrene terrene, Domain domain) {
        super(scheme, terrene, domain);
    }

    @Override

    protected <ID extends Comparable<ID>, Q extends Manufacture<Log, Garner, Indicia, ID, Q>, D extends Gathering<Log, Garner, Indicia, D, O, F>, O extends Notion<Log, Garner, Indicia, O>, N extends Fact.Named<Log, Garner, Indicia, N, F>, F extends Fact<Log, Garner, Indicia, N, F>> Catalog<Log, Garner, Indicia, D, O, N> initCatalog(Library<Log, Garner, Indicia> library, Memory<Log, Garner> memory, Dogma.Ethereal<Log, Garner, Indicia, ID, Q> ethereal) throws CheckedException {
        return null;
    }

    @Override
    protected <PATH extends Comparable<PATH>, ID extends Comparable<ID>, T extends Concept.Tangible<Log, Garner, PATH, Indicia, T, M>,M extends Matter<S,L,M,OCCURRENCE>, CAT extends Catalog<Log, Garner, PATH, ID, T, C, CAT>> C initCatalog(Memory<Log, Garner, PATH> memory, Pattern separatorPattern, Map<PATH, Gathering<Log, Garner, PATH, ID, T, C, CAT>> directoriesSeed) throws CheckedException {
        return null;
    }

    @Override
    public int compareTo(Garner o) {
        return 0;
    }
}
