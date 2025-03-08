/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import dev.inward.matrix.file.*;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.UserPrincipalLookupService;
import java.nio.file.spi.FileSystemProvider;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public abstract class Catalog<S extends Scheme<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,LK extends LibraryKey<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,L extends Library<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,PATH extends Comparable<PATH>,CK extends CatalogKey<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,C extends Catalog<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DK extends DirectoryKey<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,D extends Directory<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DR extends DirectoryReference<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DA extends DirectoryAttributes<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DRESOURCE extends DirectoryResource<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DM extends DirectoryModel<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>> extends FileSystem implements MatrixItem<PATH,CK,C> {

    protected final CK catalogKey;
    protected volatile boolean open;
    protected volatile  boolean readOnly;
    protected Map<PATH,DK> pathDirectoryKeyMap = new ConcurrentHashMap<>();

    public Catalog(CK  catalogKey) {
        this.catalogKey = catalogKey;
        this.readOnly = init(catalogKey);
        this.open = true;
    }

    protected abstract boolean init(CK catalogKey);

    @SuppressWarnings("unchecked")
    public DK findDirectoryPath(Comparable<?> path) {
        DK directoryKey = this.pathDirectoryKeyMap.get((PATH)path);
        if (directoryKey == null) {
            return buildDirectoryKey((PATH)path);
        }
        return directoryKey;
    }
    private synchronized DK buildDirectoryKey(PATH path) {
        DK directoryKey = this.pathDirectoryKeyMap.get(path);
        if (directoryKey == null) {
            directoryKey = createDirectoryKey(path);
            this.pathDirectoryKeyMap.put(path,directoryKey);
        }
        return directoryKey;
    }
    protected abstract DK createDirectoryKey(PATH path);

    @Override
    public CK getKey() {
        return catalogKey;
    }

    @Override
    public L provider() {
        return this.catalogKey.library;
    }

    @Override
    public void close() throws IOException {
        this.open = false;
    }

    @Override
    public boolean isOpen() {
        return open;
    }

    @Override
    public boolean isReadOnly() {
        return this.readOnly;
    }

    @Override
    public String getSeparator() {
        return this.catalogKey.library.get_Scheme().getProtocol().getSeparator();
    }

    @Override
    public Iterable<Path> getRootDirectories() {
        return null;
    }

    @Override
    public Iterable<FileStore> getFileStores() {
        return null;
    }

    @Override
    public Set<String> supportedFileAttributeViews() {
        return null;
    }

    @Override
    public Path getPath(String first, String... more) {
        return null;
    }

    @Override
    public PathMatcher getPathMatcher(String syntaxAndPattern) {
        return null;
    }

    @Override
    public UserPrincipalLookupService getUserPrincipalLookupService() {
        return null;
    }

    @Override
    public WatchService newWatchService() throws IOException {
        return null;
    }
}
