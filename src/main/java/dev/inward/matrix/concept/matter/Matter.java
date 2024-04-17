package dev.inward.matrix.concept.matter;

import dev.inward.matrix.Library;
import dev.inward.matrix.Scheme;
import dev.inward.matrix.concept.matter.messaging.Response;
import dev.inward.matrix.concept.matter.task.Request;
import dev.inward.matrix.engine.Zone;
import dev.inward.matrix.fact.Concept;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.nio.file.WatchEvent;
import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.locks.StampedLock;

public abstract class Matter<S extends Scheme<S,L>,L extends Library<S,L>,M extends Matter<S,L,M,OCCURRENCE>,OCCURRENCE extends Comparable<OCCURRENCE>> extends Concept<S,L,Indicia,UUID, Matter.Rubric<S,L,M,OCCURRENCE>,M> implements WatchEvent<Indicia> {

    private final StampedLock gate = new StampedLock();
    protected OCCURRENCE[] occurrences;
    protected String[] subscriptions;

    public Matter(@Nonnull Rubric<S,L,M,OCCURRENCE> rubric, @Nullable OCCURRENCE[] occurrences, @Nullable String... subscriptions) {
        super(rubric);
        this.occurrences = occurrences;
        this.subscriptions = subscriptions;
    }

    /**
     *
     * @param subscriptions
     * @return true if staging of subscriptions was successful.
     */
    public abstract boolean stageSubscriptions(String... subscriptions);
    public abstract boolean isSettled();

    /**
     *
     * @return the next (new?) active matter if it will exist, otherwise null
     */
    public abstract Rubric<S,L,M,OCCURRENCE> setSettled();

    @SuppressWarnings("unchecked")
    @Override
    public final Kind<Indicia> kind() {
        return this.identity.getPath();
    }

    @Override
    public final int count() {
        return this.occurrences.length;
    }

    public OCCURRENCE getInstance(int index) {
        if (this.isSettled()) {
            long readLock = gate.readLock();
            try {
                return this.occurrences[index];
            } finally {
                gate.unlockRead(readLock);
            }
        }
        else {
            return this.occurrences[index];
        }
    }
    public OCCURRENCE[] getAll() {
        long readLock = gate.readLock();
        try {
            return Arrays.copyOf(this.occurrences, this.occurrences.length);
        }
        finally {
            gate.unlockRead(readLock);
        }
    }

    /**
     *
     * @param occurrence
     * @return null if the instant could not be saved
     *         false if there is no new 'next matter'
     *         or true if .
     */
    public Rubric<S,L,M,OCCURRENCE> add(OCCURRENCE occurrence, boolean overrideToSettled) {
        if (this.isSettled()) {
            return null;
        }
        long writeLock = gate.writeLock();
        try {
            if (this.identity.getPath().severity.autoSettleCount >= occurrences.length) {
                this.occurrences = Arrays.copyOf(this.occurrences, occurrences.length + 1);
                this.occurrences[occurrences.length - 1] = occurrence;
                if (overrideToSettled || this.identity.getPath().severity.autoSettleCount == occurrences.length) {
                    return this.setSettled();
                }
            }
            return false;
        }
        finally {
            gate.unlockWrite(writeLock);
        }
    }
    @Override
    public Indicia context() {
        return this.identity.getPathway().get;
    }

    public static abstract class Rubric<S extends Scheme<S,L>,L extends Library<S,L>,M extends Matter<S,L,M,OCCURRENCE>,OCCURRENCE extends Comparable<OCCURRENCE>> extends Tangible<S,L,Indicia,UUID, Rubric<S,L,M,OCCURRENCE>,M> {

        protected final Indicia indicia;
        public Rubric(UUID uuid, Indicia indicia) {
            super(uuid);
            this.indicia = indicia;
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
    public static class DNS extends Rubric<Scheme.DNS, Library.DNS, Response,String> {

        public DNS(UUID uuid, Indicia indicia) {
            super(uuid, indicia);
        }

        @Override
        public String toString() {
            return null;
        }
    }
}
