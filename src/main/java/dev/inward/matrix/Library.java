package dev.inward.matrix;

import dev.inward.matrix.authority.Domain;
import dev.inward.matrix.authority.Registrar;
import dev.inward.matrix.director.library.Director;
import dev.inward.matrix.director.library.Memory;
import dev.inward.matrix.director.library.catalog.Catalog;
import dev.inward.matrix.director.library.catalog.Gathering;
import dev.inward.matrix.engine.Zone;
import dev.inward.matrix.fact.Concept;
import dev.inward.matrix.fact.Model;
import dev.inward.matrix.concept.matter.Indicia;
import dev.inward.matrix.resources.Contrivance;
import dev.inward.matrix.resources.Resource;
import dev.inward.matrix.resources.Resources;

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
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;

public abstract class Library<S extends Scheme<S,L>,L extends Library<S,L>> extends FileSystemProvider implements Comparable<L> {

    protected final S scheme;
    protected final Domain domain;
    protected final Map<Registry<S,L>, Registrar<S,L>> registrarMap = new ConcurrentHashMap<>();
    protected final Map<Catalog<S,L,?,?,?,?,?>,Librarian<S,L,?,?>> catalogs = new ConcurrentHashMap<>();
    protected final Map<Model<S,L,?,?,?>, Director<S,L,?,?>> models = new ConcurrentHashMap<>();

    protected abstract <PATH extends Comparable<PATH>, ID extends Comparable<ID>, T extends Concept.Tangible<S,L,PATH,ID, T, C>, C extends Concept<S,L, PATH, ID, T, C>, CAT extends Catalog<S,L,PATH, ID, T, C, CAT>> CAT initCatalog(Memory<Scheme.DNS, DNS, PATH> memory, Map<PATH, Gathering<Scheme.DNS, DNS, PATH, ID, T, C, CAT>> directoriesSeed) throws CheckedException;

    protected StringBuilder firstLimitReachedMessage(String className, long warnTotal, long hardLimit) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(className).append("warnTotal:").append(warnTotal).append(" hardLimit").append(hardLimit);
        return stringBuilder;
    }
    protected String hardLimitReached(String className, long warnTotal, long hardLimit, AtomicLong count, String previousMessage) {
        return firstLimitReachedMessage(className,warnTotal,hardLimit).append(' ').append(previousMessage).toString() ;
    }
    public static class DNS extends Library<Scheme.DNS, Library.DNS> {

        public DNS(Terrene terrene,Domain domain) {
            super(Scheme.DNS.Instance, terrene, domain);
        }

        @Override
        protected <PATH extends Comparable<PATH>, ID extends Comparable<ID>, T extends Concept.Tangible<Scheme.DNS, DNS, PATH, ID, T, C>, C extends Concept<Scheme.DNS, DNS, PATH, ID, T, C>, CAT extends Catalog<Scheme.DNS, DNS, PATH, ID, T, C, CAT>> CAT initCatalog(Memory<Scheme.DNS, DNS, PATH> memory, Map<PATH, Gathering<Scheme.DNS, DNS, PATH, ID, T, C, CAT>> directoriesSeed) throws CheckedException {
            return null;
        }
    }
    public static class HTML extends Library<Scheme.HTML,HTML> {
        public HTML(Terrene terrene,Domain domain) {
            super(Scheme.HTML.Instance,terrene,domain);
        }

        @Override
        protected <PATH extends Comparable<PATH>, ID extends Comparable<ID>, T extends Concept.Tangible<Scheme.HTML, HTML, PATH, ID, T, C>, C extends Concept<Scheme.HTML, HTML, PATH, ID, T, C>, CAT extends Catalog<Scheme.HTML, HTML, PATH, ID, T, C, CAT>> C initCatalog(Memory<Scheme.HTML, HTML, PATH> memory, Pattern separatorPattern, Map<PATH, Gathering<Scheme.HTML, HTML, PATH, ID, T, C, CAT>> directoriesSeed) throws CheckedException {
            return null;
        }
    }

    public Library(S scheme, Domain domain) {
        super();
        this.scheme = scheme;
        this.domain = domain;

    }
    public final Map<Character, Model<S,L,PATH,?,?,?,?,?,?>> getSiglaModelMatching() {
        return siglaModelMatching;
    }

    @Override
    public String getScheme() {
        return this.scheme.scheme;
    }

    public S get_Scheme() {
        return this.scheme;
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
    public ConceptPath<S,L,?,?,?,?> getPath(URI uri) {
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
    public <PATH extends Comparable<PATH>,ID extends Comparable<ID>,T extends Concept.Tangible<S,L,PATH,ID,T,C>,C extends Concept<S,L,PATH,ID,T,C>> void _copy(Concept<S,L,PATH,ID,T,C> concept, T target, StandardCopyOption... copyOptions) {
        if ()
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

    protected abstract <PATH extends Comparable<PATH>,ID extends Comparable<ID>,T extends Concept.Tangible<S,L,PATH,ID,T,C>,C extends Concept<S,L,PATH,ID,T,C>,CAT extends Catalog<S,L,PATH,ID,T,C,CAT>> CAT initCatalog(Memory<S,L,PATH> memory, Pattern separatorPattern, Gathering<S,L,PATH,ID,T,C,CAT> directoriesSeed) throws CheckedException;

    public CodeSigner[] getCodeSigners(Zone zone) {

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

    public static class Log extends Library<Scheme.Log, Log> {


        public Log(Terrene terrene, Domain domain) {
            super(Scheme.Log.Instance, terrene, domain);
        }

        @Override
        protected <PATH extends Comparable<PATH>, ID extends Comparable<ID>, T extends Concept.Tangible<Scheme.Log, Log, PATH, ID, T, C>, C extends Concept<Scheme.Log, Log, PATH, ID, T, C>, CAT extends Catalog<Scheme.Log, Log, PATH, ID, T, C, CAT>> C initCatalog(Memory<Scheme.Log, Log, PATH> memory, Pattern separatorPattern, Map<PATH, Gathering<Scheme.Log, Log, PATH, ID, T, C, CAT>> directoriesSeed) throws CheckedException {
            return null;
        }
    }
    public static class Dogma extends Library<Scheme.Dogma, Dogma> {

        public Dogma(Terrene terrene, Domain domain) {
            super(Scheme.Dogma.Instance, terrene, domain);
        }

        @Override
        protected <PATH extends Comparable<PATH>, ID extends Comparable<ID>, T extends Concept.Tangible<Scheme.Dogma, Dogma, PATH, ID, T, C>, C extends Concept<Scheme.Dogma, Dogma, PATH, ID, T, C>, CAT extends Catalog<Scheme.Dogma, Dogma, PATH, ID, T, C, CAT>> C initCatalog(Memory<Scheme.Dogma, Dogma, PATH> memory, Pattern separatorPattern, Map<PATH, Gathering<Scheme.Dogma, Dogma, PATH, ID, T, C, CAT>> directoriesSeed) throws CheckedException {
            return null;
        }
    }
}
