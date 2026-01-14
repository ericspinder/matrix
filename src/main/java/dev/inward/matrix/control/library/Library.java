/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.control.library;

import dev.inward.matrix.Seat;
import dev.inward.matrix.concept.fact.Cabin;
import dev.inward.matrix.concept.fact.directory.*;
import dev.inward.matrix.control.Control;
import dev.inward.matrix.control.authority.Authority;
import dev.inward.matrix.control.authority.AuthorityModel;
import dev.inward.matrix.control.authority.AuthorityView;
import dev.inward.matrix.control.domain.Domain;
import dev.inward.matrix.control.scheme.Scheme;
import dev.inward.matrix.control.scheme.SchemeModel;
import dev.inward.matrix.control.scheme.SchemeView;
import dev.inward.matrix.concept.fact.FactKey;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.net.URI;
import java.nio.file.*;
import java.nio.file.attribute.UserPrincipalLookupService;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public abstract class Library<S extends Scheme<S,SV,SM,L,LV,LM,A,AV,AM,DF,DK,DV,DM,DL,DX,PATH>,SV extends SchemeView<S,SV,SM,L,LV,LM,A,AV,AM,DF,DK,DV,DM,DL,DX,PATH>,SM extends SchemeModel<S,SV,SM,L,LV,LM,A,AV,AM,DF,DK,DV,DM,DL,DX,PATH>,L extends Library<S,SV,SM,L,LV,LM,A,AV,AM,DF,DK,DV,DM,DL,DX,PATH>,LV extends LibraryView<S,SV,SM,L,LV,LM,A,AV,AM,DF,DK,DV,DM,DL,DX,PATH>,LM extends LibraryModel<S,SV,SM,L,LV,LM,A,AV,AM,DF,DK,DV,DM,DL,DX,PATH>,A extends Authority<S,SV,SM,L,LV,LM,A,AV,AM,DF,DK,DV,DM,DL,DX,PATH>,AV extends AuthorityView<S,SV,SM,L,LV,LM,A,AV,AM,DF,DK,DV,DM,DL,DX,PATH>,AM extends AuthorityModel<S,SV,SM,L,LV,LM,A,AV,AM,DF,DK,DV,DM,DL,DX,PATH>,DF extends Directory<S,SV,SM,L,LV,LM,A,AV,AM,DF,DK,DV,DM,DL,DX,PATH>,DK extends DirectoryKey<S,SV,SM,L,LV,LM,A,AV,AM,DF,DK,DV,DM,DL,DX,PATH>,DV extends DirectoryView<S,SV,SM,L,LV,LM,A,AV,AM,DF,DK,DV,DM,DL,DX,PATH>,DM extends DirectoryModel<S,SV,SM,L,LV,LM,A,AV,AM,DF,DK,DV,DM,DL,DX,PATH>,DL extends DirectoryLibrarian<S,SV,SM,L,LV,LM,A,AV,AM,DF,DK,DV,DM,DL,DX,PATH>,DX extends DirectoryContext<S,SV,SM,L,LV,LM,A,AV,AM,DF,DK,DV,DM,DL,DX,PATH>,PATH extends Comparable<PATH>> extends FileSystem implements Control<L,LV,LM> {

    protected final UUID uuid = UUID.randomUUID();
    protected final S scheme;
    protected final Domain domain;
    protected final int port;
    protected Map<PATH, Cabin<DF,DK,DV,DM,DL,DX>> pathDirectoryMap = new ConcurrentHashMap<>();
    protected Map<String, Seat<A,AV,AM,AC,AX>> authorityMap = new ConcurrentHashMap<>();
    private boolean open = true;
    private boolean readOnly = false;
    private final LibraryKey libraryKey;

    public Library(LibraryKey libraryKey, S scheme, Domain domain, int port) {
        this.libraryKey = libraryKey.check(scheme,domain,port);
        this.scheme = scheme;
        this.domain = domain;
        this.port = port;
    }
    public static LibraryKey getLibraryKey(URI uri) {
        return new LibraryKey(uri.getScheme(),uri.getHost(),uri.getPort());
    }
    public record LibraryKey(String terrineScheme, String domainName, int port) implements Comparable<LibraryKey> {

        @Override
        public int compareTo(@NotNull LibraryKey that) {
            int isZero = this.terrineScheme.compareTo(that.terrineScheme);
            if (isZero == 0) {
                isZero = this.domainName.compareTo(that.domainName);
                if (isZero == 0) {
                    return Integer.compare(this.port,that.port);
                }
            }
            return isZero;
        }
        public LibraryKey check(Scheme<?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?> scheme, Domain domain, int port) {
            if (scheme.getScheme().equals(this.terrineScheme) && domain.getDomainName().equals(this.domainName) && port == this.port) {
                return this;
            } else {
                throw new IllegalArgumentException(String.format("LibraryKey %s is not compatible with %s %s %d",this,scheme,domain,port));
            }
        }
    }

    @Override
    public UUID getUuid() {
        return uuid;
    }

    public Domain getDomain() {
        return domain;
    }

    public int getPort() {
        return port;
    }

    public DF findDirectory(PATH path) {
        DF directory = pathDirectoryMap.get(path);
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

    public void setOpen(boolean open) {
        this.open = open;
    }

    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
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

    @NotNull
    @Override
    public FactKey<?,?,?,?,?,?> getPath(@NotNull String first, String... more) {
        StringBuilder stringBuilder = new StringBuilder();
        if (first.startsWith(this.getSeparator())) {
            stringBuilder.append(first);
        } else {
            stringBuilder.append(first);
        }
        for (String s : more) {
            if (s.startsWith(this.getSeparator())) {
                stringBuilder.append(s);
            } else {
                stringBuilder.append(this.getSeparator()).append(s);
            }
        }
        return this.getFileKey(stringBuilder.toString());
    }
    public FactKey<?,?,?,?,?,?> getFileKey(String path) {
        String directoryPath;
        int lastIndexOfSeparator = path.lastIndexOf(this.getSeparator());
        if (lastIndexOfSeparator == -1) {
            directoryPath = path.substring(0,this.toString().lastIndexOf(this.getSeparator()));
        }
        else {
            directoryPath = path.substring(0,lastIndexOfSeparator);
        }
        DF directoryFile = this.pathDirectoryMap.get(directoryPath);
        if (directoryFile == null && lastIndexOfSeparator < path.length() - 1) {
            directoryFile = this.buildDirectory(this.newDirectoryKey(URI.create(directoryPath)));
            if (directoryFile.getKey().toString().equals(path)) {
                return directoryFile.getKey();
            }
        }

    }

    public LibraryKey getLibraryKey() {
        return libraryKey;
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

    @Override
    public int compareTo(@NotNull L that) {
        return this.libraryKey.compareTo(that.getLibraryKey());
    }

}
