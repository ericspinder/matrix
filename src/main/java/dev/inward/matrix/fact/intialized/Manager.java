package dev.inward.matrix.fact.intialized;

import dev.inward.matrix.fact.datum.Identity;
import dev.inward.matrix.fact.Factory;
import dev.inward.matrix.resources.Resource;
import dev.inward.matrix.resources.Storage;
import dev.inward.matrix.fact.notion.concept.*;
import dev.inward.matrix.fact.datum.Standard;

import java.util.Map;

public class Manager<A extends Manager<A,Z,U,I,X,B,D,F,C,T,V,M>,Z extends Intialized<Z,I,X>,U extends Functionary<A,Z,U,I,X,B,D>,I extends Identity<I,X>,X extends Context<X>,B extends Book<A,Z,U,I,X,B,D>,D extends Delegated<A,Z,U,I,X,B,D>,F extends Fabrication<F,C,T,V,M>,C extends Concept<C,M>,T extends Effect<F,C,T,V,M>,V extends Volume<F,C,T,V,M>,M extends Mortal<F,C,T,V,M>> extends Factory<A,Z,U,I,X,B,D,F,C,T,V,M> {

    public Manager(M mortal, Storage storage, Map<Standard<?,Z,I,X>, Resource<A,?,?,?,Z,U,I,X,B,D>> standardResourcesMap) {
        super(mortal, storage, standardResourcesMap);
    }

    @Override
    public int compareTo(Manager that) {
        return this.uuid.compareTo(that.uuid);
    }
}
