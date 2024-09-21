package dev.inward.matrix.memory;

import dev.inward.matrix.Pathway;
import dev.inward.matrix.Range;
import dev.inward.matrix.Standard;
import dev.inward.matrix.engine.Engine;
import dev.inward.matrix.fact.Concept;
import dev.inward.matrix.fact.Factory;
import dev.inward.matrix.fact.Operational;
import dev.inward.matrix.fact.Rider;
import dev.inward.matrix.fact.authoritative.notion.Aspect;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.attribute.FileStoreAttributeView;
import java.util.Map;

public abstract class Memory<PATH extends Comparable<PATH>,P extends Pathway<PATH,P>> extends FileStore implements Comparable<Memory<PATH,P>> {

    protected final String name;
    protected final Range<PATH> range;
    protected Map<Class<? extends Concept<PATH,P,?,?,?>>, Factory<PATH,P,?,?,?>> conceptClassFactoryMap;
    protected transient long totalSpace;
    protected transient long unallocatedSpace;
    protected transient long usableSpace;

    @SuppressWarnings("unchecked")
    public Memory(@Nonnull String name, @Nullable Range<PATH> range, Standard[] standards) {
        this.name = name;
        this.range = range;
        this.conceptClassFactoryMap = this.initSpaces(standards);
    }
    public abstract Map<Class<? extends Concept<PATH,P,?,?,?>>,Factory<PATH,P,?,?,?>> initSpaces(Standard[] standards);

    @Override
    public int compareTo(Memory<PATH,P> that) {
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
    public boolean supportsFileAttributeView(Class<? extends FileAttributeView> type) {
         return type.isAssignableFrom(Rider.class) || type.isAssignableFrom(Aspect.class);
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