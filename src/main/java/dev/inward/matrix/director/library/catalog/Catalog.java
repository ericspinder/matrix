package dev.inward.matrix.director.library.catalog;

import com.google.common.collect.Ordering;
import dev.inward.matrix.*;
import dev.inward.matrix.director.library.Memory;
import dev.inward.matrix.fact.Concept;
import dev.inward.matrix.fact.Criterion;
import dev.inward.matrix.fact.Predictable;
import dev.inward.matrix.fact.Representative;
import dev.inward.matrix.fact.datum.Complication;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.UserPrincipalLookupService;
import java.nio.file.spi.FileSystemProvider;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.StampedLock;
import java.util.regex.Pattern;

public abstract class Catalog<S extends Scheme<S,L>,L extends Library<S,L>,PATH extends Comparable<PATH>,ID extends Comparable<ID>,T extends Concept.Tangible<S,L,PATH,ID,T,C>,C extends Concept<S,L,PATH,ID,T,C>,CAT extends Catalog<S,L,PATH,ID,T,C,CAT>> extends FileSystem implements Comparable<CAT> {

    protected final L library;
    protected final Range<PATH> range;
    protected boolean open = true;
    protected final Map<Memory<S,L,PATH>, Clerk<S,L,?,?>> memories;
    protected final Map<Gathering<S,L,PATH,ID,T,C,CAT>,Update> directories;


    public Catalog(L library, @Nonnull Range<PATH> range, @Nullable Map<Memory<S,L,PATH>,Scheduler> memories, List<Gathering<S,L,PATH,ID,T,C,CAT>> directoriesSeed) {
        this.library = library;
        this.range = range;
        this.memories = new ConcurrentHashMap<>(memories);
        this.directories = new ConcurrentHashMap<>();
        for (Gathering<S,L,PATH,ID,T,C,CAT> gathering: directoriesSeed) {
            this.directories.put(gathering,new Update());
        }
    }

    public boolean processFailure(Complication<S,L,PATH,ID,T,C,?,?,?,?,?> complication, MatrixException matrixException) {

        return true;
    }

    public L getLibrary() {
        return library;
    }

    public Range<PATH> getRange() {
        return this.range;
    }

    public Representative<S,L,PATH,ID,T,C> register(C concept, Gathering<S,L,PATH,ID,T,C,CAT> gathering) {
        gathering
    }

    public final Pattern getBarrierSigilPattern() {
        return barrierSigilPattern;
    }



    public final Map<Range<PATH>, Memory<S,L,PATH>> getPathsMemoryMatching() {
        return pathsMemoryMatching;
    }

    public final Map<PATH, Map<Gathering.Index<S,L,PATH,?,?,?,?,?>,Instant>> getDirectoriesLastUpdated() {
        return directoriesLastUpdated;
    }

    @Override
    public int compareTo(C that) {
        int isZero = this.library.compareTo(that.library);
        if (isZero == 0) {
            isZero = this.memory.compareTo(that.memory);
        }
        return isZero;
    }

    @Override
    public FileSystemProvider provider() {
        return this.library;
    }

    @Override
    public void close() throws IOException {

    }

    @Override
    public boolean isOpen() {
        return open;
    }

    @Override
    public boolean isReadOnly() {
        ;
    }

    @Override
    public String getSeparator() {
        return "/";
    }

    @Override
    public Iterable<Path> getRootDirectories() {
        return null;
    }

    @Override
    public Iterable<FileStore> getFileStores() {
        return new Iterable<FileStore>() {
            @Override
            public Iterator<FileStore> iterator() {
                return new Iterator<FileStore>() {
                    @Override
                    public boolean hasNext() {
                        return false;
                    }

                    @Override
                    public FileStore next() {
                        return super.;
                    }
                };
            }
        };
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
    public Predictable<S,L,PATH,ID,T,C,?,?,?,?,?> newWatchService() throws IOException {
        return null;
    }

    protected class Update {

        private StampedLock gate = new StampedLock();
        private Instant updateInstant;
        private BitSet flags;

        protected Update() {}

        public Instant getUpdateInstant() {
            long read = this.gate.readLock();
            try {
                return updateInstant;
            }
            finally {
                this.gate.unlockRead(read);
            }
        }
        public boolean flagExists(BitSet marker) {
            return this.flags.intersects(marker);
        }
        public boolean addFlag(String token) {
            return this.flags..add(token);
        }
        public boolean removeToken(String token) {
            return this.tokens.remove(token);
        }

        public String addToken() {

        }
    }

}
