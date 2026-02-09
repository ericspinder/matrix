/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.concept.catalog;

import dev.inward.matrix.concept.fact.*;
import dev.inward.matrix.control.Control;
import dev.inward.matrix.item.datum.administrator.Persona;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.ParameterizedType;
import java.nio.file.FileStore;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.attribute.FileStoreAttributeView;
import java.time.Instant;
import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;

public abstract class Catalog<CC extends Catalog<CC, CV, CM,TS>, CV extends CatalogView<CC, CV, CM,TS>, CM extends CatalogModel<CC, CV, CM,TS>,TS extends TargetSource> extends FileStore implements Control<CC,CV,CM> {

    protected final Mount mount;
    protected final String name;
    protected final boolean readOnly;
    private final Map<Librarian<?,?,?,?,?,?>, Instant> seenLibrarians = new WeakHashMap<>();
    private TS targetSource;
    protected Deque<TS> failoverTargetSources = new LinkedBlockingDeque<>();
    protected StampedLock targetSourceLock = new StampedLock();
    protected final Instant creationTime = Instant.now();

    public Catalog(final Mount mount, String name, boolean readOnly, Map<String,Object> attributes) {
        this.mount = mount;
        this.name = name;
        this.readOnly = readOnly;
        this.targetSource = createTargetSource(attributes);
    }
    protected abstract TS createTargetSource(Map<String,Object> attributes);
    public void createFailoverTS(Map<String,Object> attributes) {
        this.failoverTargetSources.add(createTargetSource(attributes));
    }

    public TS getTargetSource() {
        long stamp = this.targetSourceLock.readLock();
        try {
            return this.targetSource;
        } finally {
            this.targetSourceLock.unlockRead(stamp);
        }
    }
    public void failoverTargetSource() {
        long stamp = this.targetSourceLock.writeLock();
        try {
            this.targetSource = failoverTargetSources.poll();
        } finally {
            this.targetSourceLock.unlockWrite(stamp);
        }
    }

    public <F extends Fact<F,K,V,M,L,X>,K extends FactKey<F,K,V,M,L,X>,V extends FactView<F,K,V,M,L,X>,M extends FactModel<F,K,V,M,L,X>,L extends Librarian<F,K,V,M,L,X>,X extends FactContext<F,K,V,M,L,X>> F getFile(@NotNull K key, @NotNull L librarian, @NotNull Persona persona) {
        if (this.seenLibrarians.containsKey(librarian)) {
            this.seenLibrarians.put(librarian, Instant.now());
        }
        else { this.registerUnknownLibrarian(librarian); }

        return null;
    }
    private synchronized <F extends Fact<F,K,V,M,L,X>,K extends FactKey<F,K,V,M,L,X>,V extends FactView<F,K,V,M,L,X>,M extends FactModel<F,K,V,M,L,X>,L extends Librarian<F,K,V,M,L,X>,X extends FactContext<F,K,V,M,L,X>> void registerUnknownLibrarian(@NotNull L librarian) {
        if (this.seenLibrarians.containsKey(librarian)) {this.seenLibrarians.put(librarian,Instant.now());}
        else { this.seenLibrarians.put(enrollUnknownLibrarian(librarian),Instant.now()); }


    }
    protected <F extends Fact<F,K,V,M,L,X>,K extends FactKey<F,K,V,M,L,X>,V extends FactView<F,K,V,M,L,X>,M extends FactModel<F,K,V,M,L,X>,L extends Librarian<F,K,V,M,L,X>,X extends FactContext<F,K,V,M,L,X>> L enrollUnknownLibrarian(L librarian) {
        return librarian;
    }

    @Override
    public String name() {
        return this.name;
    }

    @Override
    public Instant getCreateInstant() {
        return this.creationTime;
    }

    @Override
    public String type() {
        return this.getClass().getCanonicalName();
    }

    @Override
    public boolean isReadOnly() {
        return readOnly;
    }
    @Override
    public <V extends FileStoreAttributeView> V getFileStoreAttributeView(Class<V> type) {
        ((Class<V>)((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1]).getConstructor();
    }
    @Override
    public boolean supportsFileAttributeView(Class<? extends FileAttributeView> type) {
        for (Librarian<?,?,?,?,?,?> librarian : seenLibrarians.keySet()) {
            if (type.isAssignableFrom(librarian.getViewClass())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean supportsFileAttributeView(String name) {
        for (Librarian<?,?,?,?,?,?> librarian : seenLibrarians.keySet()) {
            if (librarian.getViewClass().getCanonicalName().equals(name)) {
                return true;
            }
        }
        return false;
    }

}
