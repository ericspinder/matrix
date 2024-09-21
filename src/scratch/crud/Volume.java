package crud;

import dev.inward.matrix.Context;
import dev.inward.matrix.fact.authoritative.notion.Omnibus;
import dev.inward.matrix.fact.authoritative.notion.concept.Construct;
import dev.inward.matrix.fact.authoritative.notion.concept.Effect;
import dev.inward.matrix.fact.authoritative.notion.concept.Fabrication;

public class Volume<F extends Fabrication<F,C,E,V,M>,C extends Protocol<C,M>,E extends Effect<F,C,E,V,M>,V extends Volume<F,C,E,V,M>,M extends Construct<C,M>> extends Omnibus<F,C,E,Identity.Ego, Context.Demarc,V,M> {

    public Volume(E operational) {
        super(operational);
    }
}
