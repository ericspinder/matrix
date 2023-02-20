package dev.inward.matrix.fact.authoritative;

import dev.inward.matrix.fact.tracked.Controller;
import dev.inward.matrix.personality.Personality;

public class Security<VERSION extends Comparable<VERSION>,EXPIRE extends Comparable<EXPIRE>,S extends Security<VERSION,EXPIRE,S>> extends Controller<VERSION,EXPIRE,S> {

    protected final Personality<?,?,?,VERSION,EXPIRE,S> personality;

    public Security(VERSION version, EXPIRE expire, Personality<?,?,?,VERSION,EXPIRE,S> personality) {
        super(version, expire);
        this.personality = personality;
    }
}
