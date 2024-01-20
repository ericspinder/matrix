package dev.inward.matrix;

import dev.inward.matrix.authority.Domain;
import dev.inward.matrix.authority.dns.Terrene;
import dev.inward.matrix.director.library.Memory;
import dev.inward.matrix.director.library.catalog.Catalog;
import dev.inward.matrix.director.library.catalog.Gathering;
import dev.inward.matrix.fact.Fact;
import dev.inward.matrix.fact.authoritative.notion.Dream;
import dev.inward.matrix.fact.authoritative.notion.Notion;

public abstract class Soul extends Library<Anima,Soul, Identity.Ethereal.SuperEgo>  {

    public Soul(Anima scheme, Terrene terrene, Domain domain, Memory<Identity.Ethereal.SuperEgo, Dream>... memories) {
        super(scheme, terrene, domain, memories);
    }

    @Override
    protected <ID extends Comparable<ID>, Q extends Manufacture<Anima, Soul, Identity.Ethereal.SuperEgo, ID, Q>, D extends Gathering<Anima, Soul, Identity.Ethereal.SuperEgo, D, O, F>, O extends Notion<Anima, Soul, Identity.Ethereal.SuperEgo, O>, N extends Identity.Tangible.Named<Anima, Soul, Identity.Ethereal.SuperEgo, N, F>, F extends Fact<Anima, Soul, Identity.Ethereal.SuperEgo, N, F>> Catalog<Anima, Soul, Identity.Ethereal.SuperEgo, D, O, N> initCatalog(Library<Anima, Soul, Identity.Ethereal.SuperEgo> library, Memory<Anima, Soul> memory, Identity.Ethereal<Anima, Soul, Identity.Ethereal.SuperEgo, ID, Q> ethereal) throws CheckedException {
        return null;
    }

    @Override
    public int compareTo(Soul o) {
        return 0;
    }
}
