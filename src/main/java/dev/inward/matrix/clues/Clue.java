package dev.inward.matrix.clues;

public abstract class Clue<EXHIBIT> {

    protected final EXHIBIT exhibit;

    public Clue() {
        this.exhibit = this.initDefault();
    }

    public Clue(EXHIBIT exhibit) {
        this.exhibit = exhibit;
    }

    public EXHIBIT getExhibit() {
        return this.exhibit;
    }

    protected abstract EXHIBIT initDefault();
}
