package dev.inward.matrix.memory;

import dev.inward.matrix.*;
import dev.inward.matrix.Factory;
import dev.inward.matrix.Library;
import dev.inward.matrix.operation.Operation;

import javax.annotation.Nonnull;
import java.nio.file.FileStore;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.attribute.FileStoreAttributeView;
import java.util.Map;
import java.util.Properties;

public abstract class Memory<S extends Scheme<S,L,PATH>,L extends Library<S,L,PATH>,PATH extends Comparable<PATH>,O extends Operation<PATH,?,?,?>> extends FileStore implements Comparable<Memory<S,L,PATH,O>> {

    protected final Library<S,L,PATH> library;
    protected final Range<PATH> range;
    protected final Properties properties;
    protected Map<Class<? extends Representative<PATH,?,?,?,?,?>>, Factory<PATH,?,?,?,?,?>> conceptClassFactoryMap;

    @SuppressWarnings("unchecked")
    public Memory(Library<S,L,PATH> library, @Nonnull Range<PATH> range, @Nonnull Properties properties) {
        this.library = library;
        this.range = range;
        this.properties = new Properties(properties);
    }
    public abstract Factory<PATH,?,?,?,?,?,?>[] initContainers(Standard<>[] standards);

    public Library<?, ?, PATH> getLibrary() {
        return library;
    }

    public Range<PATH> getRange() {
        return range;
    }

    @Override
    public int compareTo(Memory<O,PATH> that) {
        return this.name.compareTo(that.name);
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public final String type() {
        return this.getClass().getCanonicalName();
    }


    @Override
    public boolean supportsFileAttributeView(Class<? extends FileAttributeView> type) {
         return type.isAssignableFrom(Ware.class);
    }

    @Override
    public <V extends FileStoreAttributeView> V getFileStoreAttributeView(Class<V> type) {
        return null;
    }

    @Override
    public Object getAttribute(String attribute) {
        return this.properties.get(attribute);
    }

    @Override
    public boolean supportsFileAttributeView(String name) {
        return name.equalsIgnoreCase("matrix");
    }


}