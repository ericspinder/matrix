package dev.inward.matrix.datum.fact.intialized;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.factory.Factory;
import dev.inward.matrix.operational.induction.Resource;
import dev.inward.matrix.operational.induction.Resources;
import dev.inward.matrix.datum.fact.notion.concept.*;
import dev.inward.matrix.meta.Standard;

import java.util.Map;

public class Manager<A extends Manager<A,Z,U,I,X,B,D,F,C,T,V,M>,Z extends Intialized<Z,I,X>,U extends Functionary<A,Z,U,I,X,B,D>,I extends Identity<I,X>,X extends Context<X>,B extends Book<A,Z,U,I,X,B,D>,D extends Delegated<A,Z,U,I,X,B,D>,F extends Fabrication<F,C,T,V,M>,C extends Concept<C,M>,T extends Effect<F,C,T,V,M>,V extends Volume<F,C,T,V,M>,M extends Mortal<F,C,T,V,M>> extends Factory<A,Z,U,I,X,B,D,F,C,T,V,M> {

    public Manager(M mortal, Resources resources, Map<Standard<?,Z,I,X>, Resource<A,?,?,?,Z,U,I,X,B,D>> standardResourcesMap) {
        super(mortal, resources, standardResourcesMap);
    }

    @Override
    public int compareTo(Manager that) {
        return this.uuid.compareTo(that.uuid);
    }
}
