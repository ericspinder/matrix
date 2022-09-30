package dev.inward.matrix.datum.fact.notion;


import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Factory;
import dev.inward.matrix.resources.Resources;
import dev.inward.matrix.datum.fact.notion.concept.*;

public abstract class Industry<Y extends Industry<Y,N,S,I,X,O,A>,N extends Notion<N,I,X,A>,S extends Aspect<Y,N,S,I,X,O,A>,I extends Identity<I,X>,X extends Context<X>,O extends Omnibus<Y,N,S,I,X,O,A>,A extends Agent<N,I,X,A>> extends Factory<Y,N,S,I,X,O,A,N,I,X,A> {

    protected final Resources<Y,N,S,I,X,O,A> resources;

    public Industry(Resources<Y,N,S,I,X,O,A> resources) {
        this.resources = resources;
    }
}
