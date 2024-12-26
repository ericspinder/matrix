package dev.inward.matrix.predictable;

import dev.inward.matrix.Addressed;
import dev.inward.matrix.Index;
import dev.inward.matrix.log.Indicia;
import dev.inward.matrix.log.Library_ofLog;
import dev.inward.matrix.log.Scheme_ofLog;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.io.Closeable;
import java.io.IOException;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.time.Instant;
import java.util.*;

public abstract class Matter<M extends Matter<M,OCCURRENCE>,OCCURRENCE extends Comparable<OCCURRENCE>> extends Addressed<Indicia,UUID, Matter.Identity<M,OCCURRENCE>,M, Matter.Representative<M,OCCURRENCE>> implements WatchEvent<Indicia>, Closeable {

    protected final Instant createTime;
    protected OCCURRENCE[] occurrences;

    public Matter(@Nonnull Identity<M,OCCURRENCE> id, @Nonnull Instant createTime, @Nullable OCCURRENCE[] occurrences) {
        super(id);
        this.createTime = createTime;
        this.occurrences = occurrences;
    }

    @Override
    public final Kind<Indicia> kind() {
        return this.identity.getIndices()[0].getPath();
    }
    public final <I extends Index<Indicia,I>> Kind<Indicia> kind(I index) {
        return index.getPath();
    }

    @Override
    public final int count() {
        return this.occurrences.length;
    }

    public boolean add(OCCURRENCE occurrence) {

    }
    public OCCURRENCE getInstance(int index) {
        return this.occurrences[index];
    }
    public OCCURRENCE[] getAll() {
        return Arrays.copyOf(this.occurrences,this.occurrences.length);
    }

    @Override
    public Indicia context() {
        return this.identity.getIndices()[0].getPath();
    }
    public <I extends Index<Indicia,I>> Indicia context(I index) {
        return index.getPath();
    }

    public static class Representative<M extends Matter<M,OCCURRENCE>,OCCURRENCE extends Comparable<OCCURRENCE>> extends dev.inward.matrix.Representative<Indicia,UUID,Identity<M,OCCURRENCE>,M, Representative<M,OCCURRENCE>> {

        public Representative(M concept, Resource<Indicia,UUID,Identity<M, OCCURRENCE>, M, Representative<M, OCCURRENCE>> resource, boolean hold, Properties properties) {
            super(concept, resource, hold, properties);
        }

    }
    public static abstract class ChainSupplier<M extends Matter<M,OCCURRENCE>,OCCURRENCE extends Comparable<OCCURRENCE>> extends dev.inward.matrix.ChainSupplier<Scheme_ofLog, Library_ofLog,Indicia,M> {

        public ChainSupplier(Library_ofLog library, Indicia indicia, Criterion criterion) {
            super(library, indicia, criterion);
        }

    }

    public static class Identity<M extends Matter<M,OCCURRENCE>,OCCURRENCE extends Comparable<OCCURRENCE>> extends dev.inward.matrix.Identity<Indicia,UUID, Identity<M,OCCURRENCE>,M, Representative<M,OCCURRENCE>> {
        @SafeVarargs
        public Identity(UUID uuid, Index<Indicia,?>... indices) {
            super(uuid, indices);
        }

        @Override
        public WatchKey register(WatchService watcher, Kind<?>[] events, Modifier... modifiers) throws IOException {
            return null;
        }

        @Override
        public String toString() {
            return null;
        }

        @Override
        public int compareTo(Matter.Identity<M,OCCURRENCE> that) {
            int isZero = this.getContext().compareTo(that.getContext());
        }
    }

}
