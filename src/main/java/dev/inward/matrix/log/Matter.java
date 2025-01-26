package dev.inward.matrix.log;

import dev.inward.matrix.Addressed;
import dev.inward.matrix.Index;
import dev.inward.matrix.Representative;
import dev.inward.matrix.predictable.Criterion;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.io.Closeable;
import java.io.IOException;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.time.Instant;
import java.util.*;
import java.util.function.Function;

public abstract class Matter<M extends Matter<M,OCCURRENCE,R,F>,OCCURRENCE extends Comparable<OCCURRENCE>,R extends Matter.Representative<M,OCCURRENCE,R,F>,F extends Matter.FileAttributes<M,OCCURRENCE,R,F>> extends Addressed<Indicia,UUID, Matter.Identity<M,OCCURRENCE,R,F>,M,R,F> implements WatchEvent<Indicia>, Closeable {

    protected OCCURRENCE[] occurrences;

    public Matter(@Nonnull Identity<M,OCCURRENCE,R,F> id, @Nonnull Instant createTime, @Nullable OCCURRENCE[] occurrences) {
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

    public static class Representative<M extends Matter<M,OCCURRENCE,R,F>,OCCURRENCE extends Comparable<OCCURRENCE>,R extends Representative<M,OCCURRENCE,R,F>,F extends FileAttributes<M,OCCURRENCE,R,F>> extends dev.inward.matrix.Representative<Indicia,UUID,Identity<M,OCCURRENCE,R,F>,M,R,F> {

        public Representative(M concept, Matter.Resource<M,OCCURRENCE,R,F> resource, boolean hold, Properties properties) {
            super(concept, resource, hold, properties);
        }

    }
//    public static abstract class ChainSupplier<M extends Matter<M,OCCURRENCE,R,F>,OCCURRENCE extends Comparable<OCCURRENCE>> extends dev.inward.matrix.ChainSupplier<Scheme_ofLog, Library_ofLog,Indicia,M> {
//
//        public ChainSupplier(Library_ofLog library, Indicia indicia, Criterion criterion) {
//            super(library, indicia, criterion);
//        }
//
//    }
    public static class Resource<M extends Matter<M,OCCURRENCE,R,F>,OCCURRENCE extends Comparable<OCCURRENCE>,R extends Representative<M,OCCURRENCE,R,F>,F extends FileAttributes<M,OCCURRENCE,R,F>> extends Addressed.Resource<Indicia,UUID,Identity<M,OCCURRENCE,R,F>,M,R,F> {

        public Resource(dev.inward.matrix.Representative<?,?,?,?,?,?> parent, String className, long warnOnTotal, long hardLimit, Function<R,R> graveDigger) {
            super(parent, className, warnOnTotal, hardLimit, graveDigger);
        }
    }
    public static class FileAttributes<M extends Matter<M,OCCURRENCE,R,F>,OCCURRENCE extends Comparable<OCCURRENCE>,R extends Representative<M,OCCURRENCE,R,F>,F extends FileAttributes<M,OCCURRENCE,R,F>> extends Addressed.FileAttributes<Indicia,UUID,Identity<M,OCCURRENCE,R,F>,M,R,F> {
        public FileAttributes(M datum) {
            super(datum);
        }
    }

    public static class Identity<M extends Matter<M,OCCURRENCE,R,F>,OCCURRENCE extends Comparable<OCCURRENCE>,R extends Representative<M,OCCURRENCE,R,F>,F extends FileAttributes<M,OCCURRENCE,R,F>> extends dev.inward.matrix.Identity<Indicia,UUID, Identity<M,OCCURRENCE,R,F>,M,R,F> {
        protected final Instant createTime;
        @SafeVarargs
        public Identity(UUID uuid, Instant createTime, Index<Indicia,?>... indices) {
            super(uuid, null, indices);
            this.createTime = createTime;
        }
        public Instant getCreateTime() {
            return this.createTime;
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
        public int compareTo(Matter.Identity<M,OCCURRENCE,R,F> that) {
            int isZero = this.createTime.compareTo(that.createTime);
            if (isZero == 0) {
                return this.id.compareTo(that.id);
            }
            return isZero;
        }
    }

}
