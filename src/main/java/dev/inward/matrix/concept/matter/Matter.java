package dev.inward.matrix.concept.matter;

import dev.inward.matrix.*;
import dev.inward.matrix.fact.*;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.io.Closeable;
import java.io.IOException;
import java.nio.file.WatchEvent;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.util.*;

public abstract class Matter<M extends Matter<M,OCCURRENCE>,OCCURRENCE extends Comparable<OCCURRENCE>> extends Addressed<Indicia,UUID, Matter.Identity<M,OCCURRENCE>,M, Matter.Representitive<M,OCCURRENCE>> implements WatchEvent<Indicia>, Closeable {

    protected final Instant createTime;
    protected OCCURRENCE[] occurrences;

    public Matter(@Nonnull Identity<M,OCCURRENCE> id, @Nonnull Instant createTime, @Nullable OCCURRENCE[] occurrences) {
        super(id);
        this.createTime = createTime;
        this.occurrences = occurrences;
    }

    @SuppressWarnings("unchecked")
    @Override
    public final Kind<Indicia> kind() {
        return this.identity.indicia;
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

    public static class Representitive<M extends Matter<M,OCCURRENCE>,OCCURRENCE extends Comparable<OCCURRENCE>> extends dev.inward.matrix.Representitive<Indicia,UUID,Identity<M,OCCURRENCE>,M, Representitive<M,OCCURRENCE>> {

        public Representitive(M concept, Resource<Indicia, Context<Indicia, OCCURRENCE>, UUID, Identity<M, OCCURRENCE>, M, Representitive<M, OCCURRENCE>> resource, boolean hold, Properties properties) {
            super(concept, resource, hold, properties);
        }

        @Override
        public Instant lastSync() {
            return null;
        }

        @Override
        public BasicFileAttributes readAttributes() throws IOException {
            return null;
        }

        @Override
        public void setTimes(FileTime lastModifiedTime, FileTime lastAccessTime, FileTime createTime) throws IOException {

        }
    }

    public static class Identity<M extends Matter<M,OCCURRENCE>,OCCURRENCE extends Comparable<OCCURRENCE>> extends dev.inward.matrix.Identity<Indicia,UUID, Identity<M,OCCURRENCE>,M, Representitive<M,OCCURRENCE>> {
        public Identity(UUID uuid,Index<Indicia,?>... indices) {
            super(uuid, indices);
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
