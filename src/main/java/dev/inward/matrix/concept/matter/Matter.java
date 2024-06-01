package dev.inward.matrix.concept.matter;

import dev.inward.matrix.Library;
import dev.inward.matrix.Pathway;
import dev.inward.matrix.Scheme;
import dev.inward.matrix.concept.matter.messaging.Engagement;
import dev.inward.matrix.fact.Concept;
import dev.inward.matrix.fact.datum.Complication;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.io.Closeable;
import java.lang.ref.SoftReference;
import java.nio.file.WatchEvent;
import java.time.Instant;
import java.util.*;

public abstract class Matter<M extends Matter<M,OCCURRENCE>,OCCURRENCE extends Comparable<OCCURRENCE>> extends Concept<Scheme.Log, Library.Log, Pathway.LogPathway,UUID, Matter.Rubric<M,OCCURRENCE>,M> implements WatchEvent<Indicia>, Closeable {

    protected OCCURRENCE[] occurrences;
    protected final SoftReference<Complication<S,L,?,?,?,?,?,?,?,M,OCCURRENCE>> complication;
    private boolean settled;

    public Matter(@Nonnull Rubric<M,OCCURRENCE> rubric, @Nullable OCCURRENCE[] occurrences, Complication<S,L,?,?,?,?,?,?,?,M,OCCURRENCE> complication, boolean settled) {
        super(rubric);
        this.occurrences = occurrences;
        if (complication != null) {
            this.complication = new SoftReference<>(complication);
            this.settled = settled;
        }
        else {
            this.complication = null;
            this.settled = true;
        }
    }

    public boolean isSettled() {
        if (this.complication == null || this.complication.get() == null) {
            return true;
        }
        return this.settled;

    }

    /**
     *
     * @return the next (new?) active matter if it will exist, otherwise null
     */
    public abstract void setSettled();

    @SuppressWarnings("unchecked")
    @Override
    public final Kind<Indicia> kind() {
        return this.identity.getPathway().getPath();
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
        return this.identity.getPathway().get;
    }

    public static abstract class Rubric<M extends Matter<M,OCCURRENCE>,OCCURRENCE extends Comparable<OCCURRENCE>> extends Tangible<Scheme.Log, Library.Log, Pathway.LogPathway,UUID, Rubric<M,OCCURRENCE>,M> {

        protected final Pathway.LogPathway logPathway;
        protected final Instant createTime;
        protected final Engagement engagement;
        public Rubric(UUID uuid, Engagement engagement, Indicia indicia, Instant createTime) {
            super(uuid);
            this.logPathway = new Pathway.LogPathway(library, engagement.);
        }

        @Override
        public int compareTo(Rubric<S,L,M,OCCURRENCE> that) {
            int isZero = this.getDomain().compareTo(that.getDomain());
            if (isZero == 0) {
                isZero = this.indicia.compareTo(that.indicia);
                if (isZero == 0) {
                    return this.id.compareTo(that.id);
                }
            }
            return isZero;
        }
    }
}
