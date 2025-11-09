/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.control.library;

import dev.inward.matrix.*;
import dev.inward.matrix.control.Control;
import dev.inward.matrix.control.authority.Authority;
import dev.inward.matrix.control.authority.AuthorityModel;
import dev.inward.matrix.control.authority.AuthorityView;
import dev.inward.matrix.control.domain.Domain;
import dev.inward.matrix.control.scheme.Scheme;
import dev.inward.matrix.control.scheme.SchemeModel;
import dev.inward.matrix.control.scheme.SchemeView;
import dev.inward.matrix.file.addressed.dns.catalogRecord.CatalogRecord;
import dev.inward.matrix.file.directory.*;

import java.io.IOException;
import java.net.URI;
import java.nio.file.*;
import java.nio.file.attribute.UserPrincipalLookupService;
import java.time.Instant;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public abstract class Library<S extends Scheme<S,SV,SM,A,AV,AM,L,LV,LM,DF,DK,DV,DM,DR,DL,DX,PATH>,SV extends SchemeView<S,SV,SM,A,AV,AM,L,LV,LM,DF,DK,DV,DM,DR,DL,DX,PATH>,SM extends SchemeModel<S,SV,SM,A,AV,AM,L,LV,LM,DF,DK,DV,DM,DR,DL,DX,PATH>,A extends Authority<S,SV,SM,A,AV,AM,L,LV,LM,DF,DK,DV,DM,DR,DL,DX,PATH>,AV extends AuthorityView<S,SV,SM,A,AV,AM,L,LV,LM,DF,DK,DV,DM,DR,DL,DX,PATH>,AM extends AuthorityModel<S,SV,SM,A,AV,AM,L,LV,LM,DF,DK,DV,DM,DR,DL,DX,PATH>,L extends Library<S,SV,SM,A,AV,AM,L,LV,LM,DF,DK,DV,DM,DR,DL,DX,PATH>,LV extends LibraryView<S,SV,SM,A,AV,AM,L,LV,LM,DF,DK,DV,DM,DR,DL,DX,PATH>,LM extends LibraryModel<S,SV,SM,A,AV,AM,L,LV,LM,DF,DK,DV,DM,DR,DL,DX,PATH>,DF extends Directory<S,SV,SM,A,AV,AM,L,LV,LM,DF,DK,DV,DM,DR,DL,DX,PATH>,DK extends DirectoryKey<S,SV,SM,A,AV,AM,L,LV,LM,DF,DK,DV,DM,DR,DL,DX,PATH>,DV extends DirectoryView<S,SV,SM,A,AV,AM,L,LV,LM,DF,DK,DV,DM,DR,DL,DX,PATH>,DM extends DirectoryModel<S,SV,SM,A,AV,AM,L,LV,LM,DF,DK,DV,DM,DR,DL,DX,PATH>,DR extends DirectoryReference<S,SV,SM,A,AV,AM,L,LV,LM,DF,DK,DV,DM,DR,DL,DX,PATH>,DL extends DirectoryLibrarian<S,SV,SM,A,AV,AM,L,LV,LM,DF,DK,DV,DM,DR,DL,DX,PATH>,DX extends DirectoryContext<S,SV,SM,A,AV,AM,L,LV,LM,DF,DK,DV,DM,DR,DL,DX,PATH>,PATH extends Comparable<PATH>> extends FileSystem implements Control<L,LV,LM> {

    protected final UUID uuid = UUID.randomUUID();
    protected final Instant createTime = Instant.now();
    protected final S scheme;
    protected final Domain domain;
    protected final int port;
    protected Map<String,DF> pathDirectoryMap = new ConcurrentHashMap<>();

    public Library(S scheme, URI uri) {
        this.scheme = scheme;
    }

    @Override
    public UUID getUuid() {
        return uuid;
    }

    @Override
    public Instant getCreateInstant() {
        return createTime;
    }

    public DF findDirectory(URI uri) {
        DK directoryKey = this.newDirectoryKey(uri);
        DF directory = pathDirectoryMap.get(directoryKey.toString());
        if (directory == null) {
            return buildDirectory(directoryKey);
        }
        return directory;
    }
    private synchronized DF buildDirectory(DK directoryKey) {
        DF directory = this.pathDirectoryMap.get(directoryKey.toString());
        if (directory == null) {
            directory = newDirectory(directoryKey);
            this.pathDirectoryMap.put(directory.getKey().toString(),directory);
        }
        return directory;
    }
    protected abstract DK newDirectoryKey(URI uri);
    protected abstract DF newDirectory(DK directoryKey);

    @Override
    public S provider() {
        return this.scheme;
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
        return this.scheme.getProtocolParser().getProtocol().getSeparator();
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
