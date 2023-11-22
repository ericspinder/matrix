package dev.inward.matrix.policy;

import dev.inward.matrix.Library;
import dev.inward.matrix.Scheme;
import dev.inward.matrix.fact.Concept;
import dev.inward.matrix.fact.Fact;
import dev.inward.matrix.fact.Representative;
import dev.inward.matrix.Identity;
import dev.inward.matrix.Context;
import dev.inward.matrix.fact.authoritative.notion.Notion;
import dev.inward.matrix.fact.matter.Matter;

import javax.annotation.Nonnull;
import java.nio.file.FileVisitOption;
import java.util.Objects;
import java.util.function.Supplier;

/**
 * @param <BEHAVIOR> The object created during initialization
 * @param <CF> Containing Fact's class
 * @param <CO> Containing Fact's operational class
 * @param <CI> Containing Fact's Identity class
 * @param <CX> Containing Fact's Context class
 * @param <CR> Containing Fact's Representative class
 * @param <NI> Containing Notion's Identity
 * @param <NX> Containing Notion's Context
 * @param <P> This class - allows Comparable<P> to work
 */
public abstract class Policy<BEHAVIOR extends Supplier<Matter<S,L,PATH,N,?>>,DATUM,S extends Scheme<S,L>,L extends Library<S,L>,PATH extends Comparable<PATH>,ID extends Comparable<ID>,T extends Identity.Tangible<S,L,PATH,ID,T,C>,C extends Concept<S,L,PATH,ID,T,C>> implements Comparable<P> {

    protected final BEHAVIOR behavior;

    public Policy(FileVisitOption) {
        this.behavior = BEHAVIOR;
    }

    public BEHAVIOR getBehavior() {
        return this.behavior;
    }

    protected abstract BEHAVIOR initDefault(@Nonnull CR containingFact);

    @Override
    public int compareTo(P that) {
        return this.getClass().getCanonicalName().compareTo(that.getClass().getCanonicalName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        return this.getClass().getCanonicalName().compareTo(o.getClass().getCanonicalName()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.getClass().getCanonicalName());
    }

}
