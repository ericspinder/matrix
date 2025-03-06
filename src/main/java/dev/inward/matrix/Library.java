/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import dev.inward.matrix.file.*;
import dev.inward.matrix.memory.Memory;

import java.io.IOException;
import java.net.URI;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.spi.FileSystemProvider;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public abstract class Library<S extends Scheme<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,LK extends LibraryKey<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,L extends Library<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,PATH extends Comparable<PATH>,CK extends CatalogKey<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,C extends Catalog<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DK extends DirectoryKey<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,D extends Directory<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DR extends DirectoryReference<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DA extends DirectoryAttributes<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DRESOURCE extends DirectoryResource<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DM extends DirectoryModel<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>> extends FileSystemProvider implements Comparable<L>,MatrixItem<LK,L> {

    protected final LK libraryKey;
    protected final Map<Range<PATH>,C> rangeCatalogMap = new ConcurrentHashMap<>();

    protected final Map<C, Memory<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>[]> catalogMemoryMap;
    protected final Map<C,Librarian<?,?,?,?,?>[]> catalogs = new ConcurrentHashMap<>();

    protected StringBuilder firstLimitReachedMessage(String className, long warnTotal, long hardLimit) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(className).append("warnTotal:").append(warnTotal).append(" hardLimit").append(hardLimit);
        return stringBuilder;
    }
    protected String hardLimitReached(String className, long warnTotal, long hardLimit, AtomicLong count, String previousMessage) {
        return firstLimitReachedMessage(className,warnTotal,hardLimit).append(' ').append(previousMessage).toString() ;
    }

    public Library(LK libraryKey) {
        this.libraryKey = libraryKey;
        this.catalogMemoryMap = this.initCatalogs();
    }

    public void initServer(HostExperience.Server serverExperience,C catalog) {

    }

    @Override
    public LK getKey() {
        return this.libraryKey;
    }

    @Override
    public int compareTo(L that) {
        return this.libraryKey.compareTo(that.libraryKey);
    }

    protected abstract Map<C, Memory<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>[]> initCatalogs();
//    public Clerk.Network.Client getClient(URI uri) {
//        Host.Remote remote = new Host.Remote()
//        return new Clerk.Network.Client(this,)
//    }
//    public <C extends Complication<PATH,C,M,OCCURRENCE>,M extends Matter<M,OCCURRENCE>,OCCURRENCE extends Comparable<OCCURRENCE>> C register_(Predictable<PATH,F> watcher, Indicia[] events, Criterion... modifiers) throws IOException {
//        return watcher.register(this,events,modifiers);
//    }

    @SuppressWarnings("unchecked")
    @Override
    public String getScheme() {
        return this.getKey().scheme.scheme;
    }

    public S get_Scheme() {
        return this.libraryKey.scheme;
    }

    private C findCatalog(PATH filePath) {
        for (Range<PATH> range: this.rangeCatalogMap.keySet()) {
            if (range.eval(filePath)) {
                return this.rangeCatalogMap.get(range);
            }
        }
        throw new RuntimeException("Cannot find catalog for " + filePath);
    }
    @Override
    public synchronized C newFileSystem(URI uri, Map<String, ?> env) throws IOException {
        if (uri.isAbsolute() && uri.getScheme().equals(this.getScheme()) && uri.getHost().equals(this.libraryKey.domain.getDomain()) && uri.getPort() == libraryKey.port) {
            findCatalog()
            if ()
        }
        return null;
    }

    @Override
    public C getFileSystem(URI uri) {
        if (uri.isAbsolute() && uri.getScheme().equals(this.getScheme()) && uri.getHost().equals(this.libraryKey.domain.getDomain()) && uri.getPort() == libraryKey.port) {

        }
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
    public Memory getFileStore(Path path) throws IOException {
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

//    public CodeSigner[] getCodeSigners(Zone zone) {
//
//        throw new MatrixException(MatrixException.Type.CodeSigners_not_initialized,new Exception("StackTrace, should be calling getCodeSigner() only after calling getUrl()"),new IndiciaKey("getCodeSigners() failed to create CodeSigner[] needed", libraryKey.getExceptionalSeries()),new Occurrence(UUID.randomUUID(),Instant.now(), Matter.Severity.Exceptional));
//    }
}
