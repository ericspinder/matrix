package dev.inward.matrix;

import dev.inward.matrix.director.library.catalog.Catalog;
import dev.inward.matrix.fact.Addressed;
import dev.inward.matrix.fact.Rider;

import java.util.Map;

public abstract class Pathway<PATH extends Comparable<PATH>,P extends Pathway<PATH,P>> implements Addressed.Directory<PATH,P> {

    protected final Catalog<PATH,P> ledger;
    protected final Dogma.Agent owner;
    protected final Dogma.House house;
    protected final PATH path;
    protected final Map<Rule, Rider<PATH,P,?,?,?>[]> ruleRidersMap;

    public Pathway(Catalog<PATH,P> ledger, Dogma.Agent owner, Dogma.House house, PATH path, Map<Rule,Rider<PATH,P,?,?,?>[]> ruleRidersMap) {
        this.ledger = ledger;
        this.owner = owner;
        this.house = house;
        this.path = path;
        this.ruleRidersMap = ruleRidersMap;
    }

    public abstract String getPathString();

    @Override
    public PATH getPath() {
        return path;
    }

    @Override
    public Addressed.Ledger<PATH, P> getLedger() {
        return ledger;
    }

    @Override
    public int compareTo(P that) {
        int isZero = this.ledger.compareTo(that.ledger);
        if (isZero == 0) {
            return this.getPathString().compareTo(that.getPathString());
        }
        return isZero;
    }
}
