package dev.inward.matrix.library;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Diplomat;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.datum.fact.notion.concept.*;

import java.security.Permission;
import java.util.regex.Pattern;

public class Location<F extends Fact<F,I,X,P>,I extends Identity<I,X>,X extends Context<X>,P extends Diplomat<?,F,?,I,X,?,P>,FAB extends Fabrication<FAB,C,E,V,M>,C extends Concept<C,M>,E extends Effect<FAB,C,E,V,M>,V extends Volume<FAB,C,E,V,M>,M extends Mortal<FAB,C,E,V,M>> extends Permission implements Comparable<Location<F,I,X,P,FAB,C,E,V,M>> {

    protected final Pattern pattern;
    /**
     * Constructs a permission with the specified name.
     *
     * @param pattern
     */
    public Location(Pattern pattern) {
        super(pattern.toString());
        this.pattern = pattern;
    }

    @Override
    public boolean implies(Permission permission) {
        return false;
    }

    @Override
    public void checkGuard(Object object) throws SecurityException {
        super.checkGuard(object);
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String getActions() {
        return this.pattern.toString();
    }

    @Override
    public int compareTo(Location<F, I, X, P,FAB,C,E,V,M> that) {
        return this.getName().compareTo(that.getName());
    }
}
