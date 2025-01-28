package dev.inward.matrix;

import dev.inward.matrix.dns.DnsQuery;
import dev.inward.matrix.predictable.Predictable;

import java.nio.file.Path;
import java.nio.file.Watchable;

public abstract class FileKey<PATH extends Comparable<PATH>,K extends FileKey<PATH,K,FILE,F>,FILE extends MatrixFile<PATH,K,FILE,F>,F extends FileAttributes<PATH,K,FILE,F>> implements Path {

    protected final Query query;
    protected final Index<PATH> index;

    protected FileKey(Index<PATH> index, Query query) {
        this.index = index;
        this.query = query;
    }

    public Library<?, ?, PATH> getLibrary() {
        return this.library;
    }

    public abstract Range<PATH> getRange();

    public Predictable<PATH,K,FILE,F> newWatchService() {
        return new Predictable<>();
    }

}
