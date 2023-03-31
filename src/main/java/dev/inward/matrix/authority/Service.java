package dev.inward.matrix.authority;

import dev.inward.matrix.engine.Zone;
import dev.inward.matrix.fact.authoritative.Happiness;
import dev.inward.matrix.fact.authoritative.Library;
import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.authoritative.Reachable;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.UserPrincipalLookupService;
import java.util.Set;

public class Service<Z extends Zone<Z>, S extends Service<Z, S,B,R,T,H>,B extends Library<Z, S,B,R,T,H>,R extends Reachable<R>,T extends Identity.Titled<R,T>,H extends Happiness<>> extends FileSystem {



    @Override
    public Zone<> provider() {
        return null;
    }

    @Override
    public void close() throws IOException {

    }

    @Override
    public boolean isOpen() {
        return false;
    }

    @Override
    public boolean isReadOnly() {
        return false;
    }

    @Override
    public String getSeparator() {
        return null;
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
