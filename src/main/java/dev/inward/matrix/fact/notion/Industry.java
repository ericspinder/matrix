package dev.inward.matrix.fact.notion;


import dev.inward.matrix.fact.datum.Identity;
import dev.inward.matrix.fact.Factory;
import dev.inward.matrix.resources.Storage;
import dev.inward.matrix.fact.notion.concept.*;

public abstract class Industry<Y extends Industry<Y,N,S,I,X,O,A>,N extends Notion<N,I,X,?,?>,I extends Identity<I,X>,X extends Context<X>,S extends Aspect<Y,N,S,I,X,O,A>,O extends Omnibus<Y,N,S,I,X,O,A>,A extends Agent<N,I,X,A>> extends Factory<Y,N,I,X,S,O,A,N,I,X,A,M,T> {

    protected final Storage<Y,N,S,I,X,O,A> storage;

    public Industry() {
        this.storage = storage;
    }
}
