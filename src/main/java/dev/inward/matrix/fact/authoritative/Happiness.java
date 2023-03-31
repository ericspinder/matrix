package dev.inward.matrix.fact.authoritative;

public abstract class Happiness<TITLE extends Comparable<TITLE>, T extends Identity.Titled<TITLE,T>> {


    protected Happiness(T title) {
        this.title = title;
    }


}
