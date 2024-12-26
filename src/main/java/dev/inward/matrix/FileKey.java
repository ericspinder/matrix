package dev.inward.matrix;

import dev.inward.matrix.dns.DnsQuery;
import dev.inward.matrix.predictable.Predictable;

import java.nio.file.Path;
import java.nio.file.Watchable;

public abstract class FileKey<PATH extends Comparable<PATH>,K extends FileKey<PATH,K,FILE,R,F>,FILE extends MatrixFile<PATH,K,FILE,R,F>,R extends Registar<PATH,K,FILE,R,F>,F extends FileAttributes<PATH,K,FILE,R,F>> implements Watchable, Path {

    protected final Query query;

    protected FileKey(Query query) {
        this.query = query;
    }

    public abstract Library<?, ?, PATH> getLibrary();

    public abstract Range<PATH> getRange();

    public abstract Predictable<PATH,K,FILE,R,F> newWatchService();

}
