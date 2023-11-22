package dev.inward.matrix;

import dev.inward.matrix.authority.Domain;
import dev.inward.matrix.authority.dns.Terrene;
import dev.inward.matrix.director.library.Director;
import dev.inward.matrix.director.library.Memory;
import dev.inward.matrix.director.library.catalog.Catalog;
import dev.inward.matrix.director.library.catalog.Gathering;
import dev.inward.matrix.fact.Addressed;
import dev.inward.matrix.fact.Concept;
import dev.inward.matrix.fact.Fact;
import dev.inward.matrix.fact.Model;
import dev.inward.matrix.fact.authoritative.notion.Notion;
import dev.inward.matrix.fact.matter.Indicia;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.attribute.UserPrincipalLookupService;
import java.nio.file.spi.FileSystemProvider;
import java.security.CodeSigner;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public abstract class Library<S extends Scheme<S,L>,L extends Library<S,L>> extends FileSystemProvider {

    protected final S scheme;
    protected final Terrene terrene;
    protected final Domain domain;

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
    public FileStore getFileStore(Path path) throws IOException {
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

    public abstract boolean supports(Class<? extends Notion<S,L>> type);
    protected abstract <ID extends Comparable<ID>,Q extends Query<S,L,PATH,ID,Q>,D extends Gathering<S,L,PATH,D,O,F>,O extends Notion<S,L,PATH,O>,N extends Identity.Tangible.Named<S,L,PATH,N,F>,F extends Fact<S,L,PATH,N,F>> Catalog<S,L,PATH,D,O,N,F> initCatalog(Library<S,L,PATH> library, Memory<S,L,PATH> memory, Identity.Ethereal<S,L,PATH,ID,Q> ethereal) throws CheckedException;

    public CodeSigner[] getCodeSigners() {

        throw new MatrixException(MatrixException.Type.CodeSigners_not_initialized,"getCodeSigners() failed to create CodeSigner[] needed", Indicia.Focus.Assembly, Indicia.Severity.Critical,new Exception("StackTrace, should be calling getCodeSigner() only after calling getUrl()"));
    }

    public Terrene getTerrene() {
        return terrene;
    }

    public Domain getDomain() {
        return domain;
    }


    public Catalog<S, L, PATH,N> getCatalog(PATH path)
    }


}
