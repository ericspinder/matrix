package dev.inward.matrix.director.library;

import dev.inward.matrix.Library;
import dev.inward.matrix.Range;
import dev.inward.matrix.Scheme;
import dev.inward.matrix.fact.authoritative.notion.Aspect;
import dev.inward.matrix.fact.authoritative.notion.Notion;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.nio.file.FileStore;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.attribute.FileStoreAttributeView;
import java.util.UUID;

public abstract class Memory<S extends Scheme<S,L>,L extends Library<S,L>,PATH extends Comparable<PATH>> extends FileStore implements Comparable<Memory<S,L,PATH>> {

    protected final String name;
    protected final Range<PATH> range;
    protected final boolean readOnly;
    protected transient long totalSpace;
    protected transient long unallocatedSpace;
    protected transient long usableSpace;

    @SuppressWarnings("unchecked")
    public Memory(@Nonnull String name, @Nonnull boolean readOnly, @Nullable Range<PATH> range) {
        this.name = name;
        this.readOnly = readOnly;
        this.range = range;
        this.initSpaces();
    }
    public abstract void initSpaces();

    @Override
    public int compareTo(Memory<S,L,PATH> that) {
        return this.name.compareTo(that.name);
    }

    @Override
    public String name() {
        return name;
    }


    public Range<PATH> getRange() {
        return range;
    }

    @Override
    public final String type() {
        return this.getClass().getCanonicalName();
    }

    @Override
    public final boolean isReadOnly() {
        return this.readOnly;
    }

    @Override
    public long getTotalSpace() throws IOException {
        return this.totalSpace;
    }

    @Override
    public long getUsableSpace() throws IOException {
        return this.usableSpace;
    }

    @Override
    public long getUnallocatedSpace() throws IOException {
        return this.unallocatedSpace;
    }

    @Override
    public boolean supportsFileAttributeView(Class<? extends FileAttributeView> type) {
        if (type.isAssignableFrom(Notion.class))
            return library.supports((Class<? extends Aspect<S, L,PATH,?,?,?>>) type);
        return false;
    }

    @Override
    public <V extends FileStoreAttributeView> V getFileStoreAttributeView(Class<V> type) {
        return null;
    }

    @Override
    public Object getAttribute(String attribute) throws IOException {
        return null;
    }

    @Override
    public boolean supportsFileAttributeView(String name) {
        return false;
    }


}