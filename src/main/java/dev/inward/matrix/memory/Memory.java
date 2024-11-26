package dev.inward.matrix.memory;

import dev.inward.matrix.*;
import dev.inward.matrix.Aspect;
import dev.inward.matrix.fact.Factory;

import javax.annotation.Nonnull;
import java.nio.file.FileStore;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.attribute.FileStoreAttributeView;
import java.util.Map;
import java.util.Properties;

public abstract class Memory<C extends Operation<PATH,?,?,?,?,?>,PATH extends Comparable<PATH>> extends FileStore implements Comparable<Memory<C,PATH>> {

    protected final Library<?,?,PATH> library;
    protected final Range<PATH> range;
    protected final Properties properties;
    protected Map<Class<? extends Representitive<PATH,D,?,?,?,?>>, Factory<PATH,D,?,?,?,?>> conceptClassFactoryMap;

    @SuppressWarnings("unchecked")
    public Memory(Library<?,?,PATH> library, @Nonnull Range<PATH> range, @Nonnull Properties properties) {
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
    public int compareTo(Memory<PATH> that) {
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
         return type.isAssignableFrom(Representitive.class) || type.isAssignableFrom(Aspect.class);
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