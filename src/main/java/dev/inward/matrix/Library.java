package dev.inward.matrix;

import dev.inward.matrix.authority.Domain;
import dev.inward.matrix.authority.Registrar;
import dev.inward.matrix.authority.dns.Terrene;
import dev.inward.matrix.director.library.Director;
import dev.inward.matrix.director.library.Memory;
import dev.inward.matrix.director.library.catalog.Catalog;
import dev.inward.matrix.director.library.catalog.Gathering;
import dev.inward.matrix.fact.Concept;
import dev.inward.matrix.fact.Model;
import dev.inward.matrix.fact.matter.Indicia;

import java.io.IOException;
import java.net.URI;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.spi.FileSystemProvider;
import java.security.CodeSigner;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

public abstract class Library<S extends Scheme<S,L>,L extends Library<S,L>> extends FileSystemProvider implements Comparable<L> {

    protected final S scheme;
    protected final Terrene terrene;
    protected final Domain domain;

    protected final Map<Registry<S,L>, Registrar<S,L>>
    protected final Map<Catalog<S,L,?,?,?,?,?>,Librarian<S,L,?,?>> catalogs = new ConcurrentHashMap<>();
    protected final Map<Model<S,L,?,?,?>, Director<S,L,?,?>> models = new ConcurrentHashMap<>();

    public static class DNS extends Library<Scheme.DNS, Library.DNS> {

        public DNS(Scheme.DNS dnsScheme, Terrene terrene,Domain domain) {
            super(dnsScheme, terrene, domain);
        }
    }
    public static class HTML extends Library<Scheme.HTML,HTML> {
        public HTML(Scheme.HTML htmlScheme,Terrene terrene,Domain domain) {
            super(htmlScheme,terrene,domain);
        }
    }

    public Library(S scheme, Terrene terrene, Domain domain) {
        super();
        this.scheme = scheme;
        this.terrene = terrene;
        this.domain = domain;

    }
    public final Map<Character, Model<S,L,PATH,?,?,?,?,?,?>> getSiglaModelMatching() {
        return siglaModelMatching;
    }

    @Override
    public String getScheme() {
        return this.scheme.scheme;
    }

    @Override
    public Catalog<S,L,?,?,?,?,?> newFileSystem(URI uri, Map<String, ?> env) throws IOException {
        return null;
    }

    @Override
    public Catalog<S,L,?,?,?,?,?> getFileSystem(URI uri) {
        return null;
    }

    @Override
    public Concept<S,L,?,?,?,?> getPath(URI uri) {
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
    public Memory<S,L,?> getFileStore(Path path) throws IOException {
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

    protected abstract <PATH extends Comparable<PATH>,ID extends Comparable<ID>,T extends Identity.Tangible<S,L,PATH,ID,T,C>,C extends Concept<S,L,PATH,ID,T,C>,CAT extends Catalog<S,L,PATH,ID,T,C,CAT>> C initCatalog(Memory<S,L,PATH> memory, Pattern separatorPattern, Map<PATH,Gathering<S,L,PATH,ID,T,C,CAT>> directoriesSeed) throws CheckedException;

    public CodeSigner[] getCodeSigners() {

        throw new MatrixException(MatrixException.Type.CodeSigners_not_initialized,"getCodeSigners() failed to create CodeSigner[] needed", Indicia.Focus.Assembly, Indicia.Severity.Critical,new Exception("StackTrace, should be calling getCodeSigner() only after calling getUrl()"));
    }

    public Terrene getTerrene() {
        return terrene;
    }

    public Domain getDomain() {
        return domain;
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
