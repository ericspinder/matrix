package dev.inward.matrix;

import dev.inward.matrix.dns.resourceRecord.ServiceLocationRecord;
import dev.inward.matrix.engine.Zone;
import dev.inward.matrix.operation.Operation;
import dev.inward.matrix.predictable.Complication;
import dev.inward.matrix.predictable.Criterion;
import dev.inward.matrix.log.Matter;
import dev.inward.matrix.predictable.Predictable;
import dev.inward.matrix.log.Indicia;
import dev.inward.matrix.memory.Memory;

import java.io.IOException;
import java.net.URI;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.spi.FileSystemProvider;
import java.security.CodeSigner;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public abstract class Library<S extends Scheme<S,L,PATH>,L extends Library<S,L,PATH>,PATH extends Comparable<PATH>> extends FileSystemProvider implements Comparable<L>  {

    protected final S scheme;

    protected final Domain domain;
    protected final int port;

    protected final Map<ServiceLocationRecord,Experience> hostExperienceMap = new ConcurrentHashMap<>();
    protected final Map<Ledger<PATH>,Librarian<PATH,?,?,?,?>[]> catalogs = new ConcurrentHashMap<>();

    protected <ID extends Comparable<ID>, I extends Identity<PATH, ID, I, A, R, PR>, A extends Addressed<PATH, ID, I, A, R, PR>, R extends Representative<PATH, ID, I, A, R, PR>, PR extends Representative<PATH, ?, ?, ?, PR, ?>, C extends Operation<PATH, ID, I, A, R, PR>, L extends Ledger<PATH>> L initLedger(Memory<C, PATH> memory, Map<PATH, Gathering<PATH, ID, I, A, R, PR, C>> directoriesSeed) throws CheckedException {
        return null;
    }

    protected StringBuilder firstLimitReachedMessage(String className, long warnTotal, long hardLimit) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(className).append("warnTotal:").append(warnTotal).append(" hardLimit").append(hardLimit);
        return stringBuilder;
    }
    protected String hardLimitReached(String className, long warnTotal, long hardLimit, AtomicLong count, String previousMessage) {
        return firstLimitReachedMessage(className,warnTotal,hardLimit).append(' ').append(previousMessage).toString() ;
    }

    public Library(S scheme, Domain domain, int port) {
        this.scheme = scheme;
        this.domain = domain;
        this.port = port;
    }
    public Clerk.Network.Client getClient(URI uri) {
        Host.Remote remote = new Host.Remote()
        return new Clerk.Network.Client(this,)
    }
    public <C extends Complication<PATH,C,M,OCCURRENCE>,M extends Matter<M,OCCURRENCE>,OCCURRENCE extends Comparable<OCCURRENCE>> C register_(Predictable<PATH,F> watcher, Indicia[] events, Criterion... modifiers) throws IOException {
        return watcher.register(this,events,modifiers);
    }

    @SuppressWarnings("unchecked")
    @Override
    public String getScheme() {
        return this.scheme.scheme;
    }

    public S get_Scheme() {
        return this.scheme;
    }

    @Override
    public Ledger<PATH> newFileSystem(URI uri, Map<String, ?> env) throws IOException {
        return null;
    }

    @Override
    public Ledger<PATH> getFileSystem(URI uri) {
        return null;
    }

    @Override
    public Path getPath(URI uri) {
        return null;
    }

    @Override
    public SeekableByteChannel newByteChannel(Path path, Set<? extends OpenOption> options, FileAttribute<?>... attrs) throws IOException {
        return null;
    }

    @Override
    public DirectoryStream<Path> newDirectoryStream(Path dir, DirectoryStream.Filter<? super Path> filter) throws IOException {
        return null;
    }

    @Override
    public void createDirectory(Path dir, FileAttribute<?>... attrs) throws IOException {

    }

    @Override
    public void delete(Path path) throws IOException {

    }

    @Override
    public void copy(Path source, Path target, CopyOption... options) throws IOException {
    }

    @Override
    public void move(Path source, Path target, CopyOption... options) throws IOException {

    }

    @Override
    public boolean isSameFile(Path path, Path path2) throws IOException {
        return false;
    }

    @Override
    public boolean isHidden(Path path) throws IOException {
        return false;
    }

    @Override
    public Memory<S,L,PATH,?> getFileStore(Path path) throws IOException {
        return null;
    }

    @Override
    public void checkAccess(Path path, AccessMode... modes) throws IOException {

    }

    @Override
    public <V extends FileAttributeView> V getFileAttributeView(Path path, Class<V> type, LinkOption... options) {
        return null;
    }

    @Override
    public <A extends BasicFileAttributes> A readAttributes(Path path, Class<A> type, LinkOption... options) throws IOException {
        return null;
    }

    @Override
    public Map<String, Object> readAttributes(Path path, String attributes, LinkOption... options) throws IOException {
        return null;
    }

    @Override
    public void setAttribute(Path path, String attribute, Object value, LinkOption... options) throws IOException {

    }

    //protected abstract <PATH extends Comparable<PATH>,ID extends Comparable<ID>,T extends Concept.Identity<S,L,PATH,ID,T,C>,C extends Concept<S,L,PATH,ID,T,C>,CAT extends Ledger<S,L,PATH,ID,T,C,CAT>> CAT initCatalog(Memory<S,L,PATH> memory, Pattern separatorPattern, Gathering<S,L,PATH,ID,T,C,CAT> directoriesSeed) throws CheckedException;

    public CodeSigner[] getCodeSigners(Zone zone) {

        throw new MatrixException(MatrixException.Type.CodeSigners_not_initialized,"getCodeSigners() failed to create CodeSigner[] needed", Indicia.Focus.Assembly, Indicia.Severity.Critical,new Exception("StackTrace, should be calling getCodeSigner() only after calling getUrl()"));
    }

    public List<Domain> getDomains() {
        return this.domains;
    }

    @Override
    public int compareTo(L that) {
        int isZero = this.domain.compareTo(that.domain);
        if (isZero == 0) {
            isZero = this.scheme.compareTo(scheme);
            if (isZero == 0) {
                return this.terrene.compareTo(that.terrene);
            }
        }
        return isZero;
    }


}
