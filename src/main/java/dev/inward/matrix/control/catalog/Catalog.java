/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.control.catalog;

import dev.inward.matrix.*;
import dev.inward.matrix.control.Control;
import dev.inward.matrix.control.authority.Authority;
import dev.inward.matrix.file.resource.record.catalogRecord.CatalogRecord;
import dev.inward.matrix.file.directory.*;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.UserPrincipalLookupService;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Catalog<DF extends Directory<DF,DK,DV,DM,DR,DL,PATH>,DK extends DirectoryKey<DF,DK,DV,DM,DR,DL,PATH>,DV extends DirectoryView<DF,DK,DV,DM,DR,DL,PATH>,DM extends DirectoryModel<DF,DK,DV,DM,DR,DL,PATH>,DR extends DirectoryReference<DF,DK,DV,DM,DR,DL,PATH>,DL extends DirectoryLibrarian<DF,DK,DV,DM,DR,DL,PATH>,PATH extends Comparable<PATH>> extends FileSystem implements Control<Catalog<DF,DK,DV,DM,DR,DL,PATH>,CatalogView<DF,DK,DV,DM,DR,DL,PATH>,CatalogModel<DF,DK,DV,DM,DR,DL,PATH>> {

    protected final Authority<DF,DK,DV,DM,DR,DL,PATH> authority;
    protected final Range<PATH> range;
    protected final CatalogRecord<?,?,?,?,?,?> catalogRecord;
    protected volatile boolean open;
    protected volatile  boolean readOnly;
    protected Map<String,DK> pathDirectoryKeyMap = new ConcurrentHashMap<>();

    public Catalog(Authority<DF,DK,DV,DM,DR,DL,PATH> authority, Range<PATH> range, CatalogRecord<?,?,?,?,?,?> catalogRecord) {
        this.authority = authority;
        this.range = Range.Parse()
    }


    public DK findDirectoryKey(String directoryString) {
        DK directoryKey = this.pathDirectoryKeyMap.get(directoryString);
        if (directoryKey == null) {
            return buildDirectoryKey(directoryString);
        }
        return directoryKey;
    }
    private synchronized DK buildDirectoryKey(String directoryString) {
        DK directoryKey = this.pathDirectoryKeyMap.get(directoryString);
        if (directoryKey == null) {
            directoryKey = newDirectoryKey(directoryString);
            this.pathDirectoryKeyMap.put(directoryString,directoryKey);
        }
        return directoryKey;
    }
    protected abstract DK newDirectoryKey(String path);

    @Override
    public Authority<DF,DK,DV,DM,DR,DL,PATH> provider() {
        return this.authority;
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
        return this.authority.get_Scheme().getgetProtocol().getSeparator();
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
