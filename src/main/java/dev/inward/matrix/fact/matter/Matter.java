package dev.inward.matrix.fact.matter;

import dev.inward.matrix.Identity;
import dev.inward.matrix.Library;
import dev.inward.matrix.Scheme;
import dev.inward.matrix.fact.Concept;

import java.lang.ref.SoftReference;
import java.nio.file.WatchEvent;
import java.time.Instant;
import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.locks.StampedLock;

public abstract class Matter<S extends Scheme<S,L>,L extends Library<S,L>,M extends Matter<S,L,M>> extends Concept<S,L,Indicia,UUID, Identity.Tangible.Rubric<S,L,M>,M> implements WatchEvent<Indicia> {

    protected StampedLock gate = new StampedLock();
    protected Instant[] occurrences;
    protected boolean settled;

    public Matter(Identity.Tangible.Rubric<S,L,M> rubric, Instant[] occurrences, boolean settled) {
        super(rubric);
        this.occurrences = occurrences;
        if (settled) setSettled();
    }

    public final boolean isSettled() {
        return this.settled;
    }

    protected final void setSettled() {
        this.settled = true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public final Kind<Indicia> kind() {
        return this.identity.getPath();
    }

    @Override
    public final int count() {
        return this.occurrences.length;
    }

    public Instant getInstance(int index) {
        long readLock = gate.readLock();
        try {
            return this.occurrences[index];
        }
        finally {
            gate.unlockRead(readLock);
        }
    }
    public Instant[] getAll() {
        if (settled) {
            return this.occurrences;
        }
        return Arrays.copyOf(this.occurrences,this.occurrences.length);
    }

    /**
     *
     * @param instant
     * @return false if the instant could not be saved due to auto settle limit being reached by this occurrence or previously - add instant to a new Matter of the same type.
     */
    public boolean add(Instant instant, boolean overrideToSettled) {
        long writeLock = gate.writeLock();
        try {
            if (this.settled) {
                return false;
            }
            if (this.identity.getPath().severity.autoSettleCount >= occurrences.length) {
                this.occurrences = Arrays.copyOf(this.occurrences, occurrences.length + 1);
                this.occurrences[occurrences.length - 1] = instant;
                if (overrideToSettled || this.identity.getPath().severity.autoSettleCount == occurrences.length) {
                    this.setSettled();
                }
                return true;
            }
            this.setSettled();
            return false;
        }
        finally {
            gate.unlockWrite(writeLock);
        }
    }

}
