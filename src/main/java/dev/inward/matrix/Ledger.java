package dev.inward.matrix;

import dev.inward.matrix.memory.Memory;
import dev.inward.matrix.predictable.Complication;
import dev.inward.matrix.predictable.Predictable;

import javax.annotation.Nullable;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.UserPrincipalLookupService;
import java.nio.file.spi.FileSystemProvider;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.StampedLock;
import java.util.function.Supplier;

public abstract class Ledger<PATH extends Comparable<PATH>> extends FileSystem implements FileKey<PATH,Ledger<PATH>> {

    protected boolean open;
    protected final Map<String,Gathering<PATH,?,?,?,?,?>[]> directoriesByClass;

    protected final Library<?,?,PATH> library;
    protected Range<PATH> range;

    protected abstract Librarian<PATH,?,?,?,?> getLibrarian();

    public Ledger(Library<?,?,PATH> library, @Nullable Map<Memory<?,PATH>, Supplier<Clerk>> memorySupplierMap, Map<String,Gathering<PATH,?,?,?,?,?>[]> directoriesSeed) {
        this.library = library;
        this.directoriesByClass = new ConcurrentHashMap<>(directoriesSeed);
    }

    public boolean processFailure(Complication<PATH,?,?,?,?> complication, MatrixException matrixException) {

        return true;
    }

    @Override
    public Library<?,?,PATH> getLibrary() {
        return library;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public Range<PATH> getRange() {
        return this.range;
    }

    @Override
    public int compareTo(Ledger<PATH> that) {
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
    public Predictable<PATH,Ledger<PATH>> newWatchService() {
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
