package dev.inward.matrix.log;

import dev.inward.matrix.*;
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

public abstract class Matter<M extends Matter<M,OCCURRENCE,R,A>,OCCURRENCE extends Comparable<OCCURRENCE>,R extends Matter.Representative<M,OCCURRENCE,R,A>,A extends Matter.MatterAttributes<M,OCCURRENCE,R,A>> extends Addressed<Indicia,UUID, Matter.Identity<M,OCCURRENCE,R,A>,M,R,A> implements WatchEvent<Indicia>, Closeable {

    protected final List<OCCURRENCE> occurrences;
    protected final Instant createTime;

    public Matter(@Nonnull Identity<M,OCCURRENCE,R,A> id, @Nonnull Instant createTime, @Nonnull OCCURRENCE[] occurrences) {
        super(id);
        this.createTime = createTime;
        this.occurrences = Collections.synchronizedList(Arrays.stream(occurrences).toList());
    }

    @Override
    public final Kind<Indicia> kind() {
        return this.identity.;
    }
    public final Kind<Indicia> kind(Index<Indicia> index) {
        return index.getPath();
    }

    @Override
    public final int count() {
        return this.occurrences.size();
    }

    public boolean add(OCCURRENCE occurrence) {
        return this.occurrences.add(occurrence);
    }
    public OCCURRENCE getInstance(int index) {
        return this.occurrences.get(index);
    }
    public List<OCCURRENCE> getAll() {
        return this.occurrences;
    }

    @Override
    public Indicia context() {
        return this.identity.getIndices()[0].getPath();
    }
    public Indicia context(Index<Indicia> index) {
        return index.getPath();
    }

    public static class Representative<M extends Matter<M,OCCURRENCE,R,A>,OCCURRENCE extends Comparable<OCCURRENCE>,R extends Representative<M,OCCURRENCE,R,A>,A extends MatterAttributes<M,OCCURRENCE,R,A>> extends dev.inward.matrix.Representative<Indicia,UUID,Identity<M,OCCURRENCE,R,A>,M,R,A> {

        public Representative(M concept, Matter.Resource<M,OCCURRENCE,R,A> resource) {
            super(concept, resource);
        }

    }
//    public static abstract class ChainSupplier<M extends Matter<M,OCCURRENCE,R,F>,OCCURRENCE extends Comparable<OCCURRENCE>> extends dev.inward.matrix.ChainSupplier<Scheme_ofLog, Library_ofLog,Indicia,M> {
//
//        public ChainSupplier(Library_ofLog library, Indicia indicia, Criterion criterion) {
//            super(library, indicia, criterion);
//        }
//
//    }
    public static class Resource<M extends Matter<M,OCCURRENCE,R,A>,OCCURRENCE extends Comparable<OCCURRENCE>,R extends Representative<M,OCCURRENCE,R,A>,A extends MatterAttributes<M,OCCURRENCE,R,A>> extends Addressed.Resource<Indicia,UUID,Identity<M,OCCURRENCE,R,A>,M,R,A> {

        public Resource(Standard standard, Function<R, R> graveDigger, Specification specification) {
            super(standard, graveDigger, specification);
        }
    }
    public static class MatterAttributes<M extends Matter<M,OCCURRENCE,R,A>,OCCURRENCE extends Comparable<OCCURRENCE>,R extends Representative<M,OCCURRENCE,R,A>,A extends MatterAttributes<M,OCCURRENCE,R,A>> extends Addressed.FileAttributes<Indicia,UUID,Identity<M,OCCURRENCE,R,A>,M,R,A> {
        public MatterAttributes(Properties properties, long size) {
            super(properties, size);
        }
    }

    public static class Identity<M extends Matter<M,OCCURRENCE,R,A>,OCCURRENCE extends Comparable<OCCURRENCE>,R extends Representative<M,OCCURRENCE,R,A>,A extends MatterAttributes<M,OCCURRENCE,R,A>> extends dev.inward.matrix.Identity<Indicia,UUID, Identity<M,OCCURRENCE,R,A>,M,R,A> {
        public Identity(Instant createTime, Index<Indicia> index,UUID uuid) {
            super(index, null, uuid);
        }


        @Override
        public String toString() {
            return null;
        }
    }

}
