package dev.inward.matrix.concept.matter;

import dev.inward.matrix.director.library.catalog.Catalog;
import dev.inward.matrix.fact.Concept;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.io.Closeable;
import java.nio.file.WatchEvent;
import java.time.Instant;
import java.util.*;

public abstract class Matter<M extends Matter<M,OCCURRENCE>,OCCURRENCE extends Comparable<OCCURRENCE>> extends Concept<Matter.Pathway,UUID, Matter.Id<M,OCCURRENCE>,M> implements WatchEvent<Indicia>, Closeable {

    protected final Instant createTime;
    protected OCCURRENCE[] occurrences;
    private boolean settled;

    public Matter(@Nonnull Id<M,OCCURRENCE> id, @Nonnull Instant createTime, @Nullable OCCURRENCE[] occurrences, boolean settled) {
        super(id);
        this.createTime = createTime;
        this.occurrences = occurrences;
        this.settled = settled;
    }

    public boolean isSettled() {
        return this.settled;

    }
    public void settle() {
        this.settled = true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public final Kind<Indicia> kind() {
        return this.identity.getPathway().indicia;
    }

    @Override
    public final int count() {
        return this.occurrences.length;
    }

    public OCCURRENCE getInstance(int index) {
        return this.occurrences[index];
    }
    public OCCURRENCE[] getAll() {
        return Arrays.copyOf(this.occurrences,this.occurrences.length);
    }

    @Override
    public Indicia context() {
        return this.identity.getPathway().indicia;
    }

    public static abstract class Id<M extends Matter<M,OCCURRENCE>,OCCURRENCE extends Comparable<OCCURRENCE>> extends Tangible<Pathway,UUID,Id<M,OCCURRENCE>,M> {

        protected final Pathway pathway;
        public Id(UUID uuid, Pathway pathway) {
            super(uuid);
            this.pathway = pathway;

        }
        @Override
        public String toString() {
            return null;
        }

        @Override
        public int compareTo(Id<M, OCCURRENCE> o) {
            return 0;
        }
    }

    public static class Pathway extends dev.inward.matrix.Pathway<Pathway,Catalog> {

        protected final Indicia indicia;

        public Pathway(Catalog catalog, Indicia indicia) {
            super(catalog);
            this.indicia = indicia;
        }


        @Override
        public String getPathString() {
            return null;
        }
    }
}
