package dev.inward.matrix.fact.authoritative;

import dev.inward.matrix.authority.Service;
import dev.inward.matrix.engine.Zone;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.attribute.FileStoreAttributeView;

public abstract class Library<Z extends Zone<Z>, S extends Service<Z,S,L,R,T>, L extends Library<Z, S, L, R,T,H>, R extends Reachable<R>,T extends Identity.Titled<R,T>,H extends Happiness<R,T>> extends FileStore {

    protected final T title;
    protected H happiness;

    public Library(T title, boolean readOnly) {
        this.title = title;
    }

    public final T getTitle() {
        return this.title;
    }
    public boolean isOpen() {

    }

    @Override
    public String name() {
        return title.toString();
    }

    @Override
    public String type() {
        return null;
    }

    @Override
    public boolean isReadOnly() {
        return false;
    }

    @Override
    public long getTotalSpace() throws IOException {
        return 0;
    }

    @Override
    public long getUsableSpace() throws IOException {
        return 0;
    }

    @Override
    public long getUnallocatedSpace() throws IOException {
        return 0;
    }

    @Override
    public boolean supportsFileAttributeView(Class<? extends FileAttributeView> type) {
        return false;
    }

    @Override
    public boolean supportsFileAttributeView(String name) {
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
}