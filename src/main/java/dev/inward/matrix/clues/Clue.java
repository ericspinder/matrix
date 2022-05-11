package dev.inward.matrix.clues;

import dev.inward.matrix.datum.fact.notion.concept.Context;

public abstract class Clue<X extends Context<X>,EXHIBIT> {

    protected final EXHIBIT exhibit;

    public Clue(EXHIBIT exhibit) {
        this.exhibit = exhibit;
    }
    public Clue(X context) {
        this.exhibit = init(context);
    }

    public EXHIBIT getExhibit() {
        return this.exhibit;
    }
    abstract EXHIBIT init(X context);
}
