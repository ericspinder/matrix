package dev.inward.matrix.director.library.catalog;

import dev.inward.matrix.*;
import dev.inward.matrix.authority.Domain;
import dev.inward.matrix.director.library.Memory;
import dev.inward.matrix.fact.Addressed;
import dev.inward.matrix.fact.Concept;
import dev.inward.matrix.fact.Model;
import dev.inward.matrix.fact.Representative;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.UserPrincipalLookupService;
import java.nio.file.spi.FileSystemProvider;
import java.time.Instant;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

public abstract class Catalog<S extends Scheme<S,L>,L extends Library<S,L>,PATH extends Comparable<PATH>,ID extends Comparable<ID>,T extends Identity.Tangible<S,L,PATH,ID,T,C>,C extends Concept<S,L,PATH,ID,T,C>,CAT extends Catalog<S,L,PATH,ID,T,C,CAT>> extends FileSystem implements Comparable<CAT> {

    protected final Memory<S,L,PATH> memory;
    protected final Pattern separatorPattern;
    protected final Map<PATH,Gathering<S,L,PATH,ID,T,C,CAT>> directories;


    public Catalog(Memory<S,L,PATH> memory,Pattern separatorPattern, Map<PATH,Gathering<S,L,PATH,ID,T,C,CAT>> directoriesSeed) {
        this.memory = memory;
        this.separatorPattern = separatorPattern;
        this.directories = new ConcurrentHashMap<>(directoriesSeed);
    }

    public Representative<S,L,PATH,ID,T,C> register(C concept, Gathering<S,L,PATH,ID,T,C,CAT> gathering) {
        gathering
    }

    public final Pattern getBarrierSigilPattern() {
        return barrierSigilPattern;
    }

    public final Map<Character, Model<S,L,PATH,?,?,?,?,?,?>> getSiglaModelMatching() {
        return siglaModelMatching;
    }

    public final Map<Range<PATH>, Memory<PATH>> getPathsMemoryMatching() {
        return pathsMemoryMatching;
    }

    public final Map<PATH, Map<Gathering.Index<S,L,PATH,?,?,?,?,?>,Instant>> getDirectoriesLastUpdated() {
        return directoriesLastUpdated;
    }

    @Override
    public int compareTo(Catalog<S,L,PATH,O,N,F> that) {
        int isZero = this.library.compareTo(that.library);
        if (isZero == 0) {
            isZero = this.memory.compareTo(that.memory);
        }
        return isZero;
    }

    @Override
    public FileSystemProvider provider() {
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
