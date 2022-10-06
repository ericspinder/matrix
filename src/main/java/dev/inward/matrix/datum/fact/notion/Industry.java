package dev.inward.matrix.datum.fact.notion;


import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Factory;
import dev.inward.matrix.resources.Storage;
import dev.inward.matrix.datum.fact.notion.concept.*;

public abstract class Industry<Y extends Industry<Y,N,S,I,X,O,A>,N extends Notion<N,I,X,A>,S extends Aspect<Y,N,S,I,X,O,A>,I extends Identity<I,X>,X extends Context<X>,O extends Omnibus<Y,N,S,I,X,O,A>,A extends Agent<N,I,X,A>> extends Factory<Y,N,S,I,X,O,A,N,I,X,A> {

    protected final Storage<Y,N,S,I,X,O,A> storage;

    public Industry(Storage<Y,N,S,I,X,O,A> storage) {
        this.storage = storage;
    }
}
