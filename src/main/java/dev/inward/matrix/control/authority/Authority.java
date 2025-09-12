/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.control.authority;

import dev.inward.matrix.*;
import dev.inward.matrix.control.library.Library;
import dev.inward.matrix.control.domain.Domain;
import dev.inward.matrix.catalog.bureau.Bureau;
import dev.inward.matrix.control.Control;
import dev.inward.matrix.control.library.LibraryModel;
import dev.inward.matrix.control.library.LibraryView;
import dev.inward.matrix.control.scheme.Scheme;
import dev.inward.matrix.control.scheme.SchemeModel;
import dev.inward.matrix.control.scheme.SchemeView;
import dev.inward.matrix.file.directory.*;

import java.io.IOException;
import java.net.URI;
import java.net.URLDecoder;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.spi.FileSystemProvider;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class Authority<S extends Scheme<S,SV,SM,A,AV,AM,L,LV,LM,DF,DK,DV,DM,DR,DL,DX,PATH>,SV extends SchemeView<S,SV,SM,A,AV,AM,L,LV,LM,DF,DK,DV,DM,DR,DL,DX,PATH>,SM extends SchemeModel<S,SV,SM,A,AV,AM,L,LV,LM,DF,DK,DV,DM,DR,DL,DX,PATH>,A extends Authority<S,SV,SM,A,AV,AM,L,LV,LM,DF,DK,DV,DM,DR,DL,DX,PATH>,AV extends AuthorityView<S,SV,SM,A,AV,AM,L,LV,LM,DF,DK,DV,DM,DR,DL,DX,PATH>,AM extends AuthorityModel<S,SV,SM,A,AV,AM,L,LV,LM,DF,DK,DV,DM,DR,DL,DX,PATH>,L extends Library<S,SV,SM,A,AV,AM,L,LV,LM,DF,DK,DV,DM,DR,DL,DX,PATH>,LV extends LibraryView<S,SV,SM,A,AV,AM,L,LV,LM,DF,DK,DV,DM,DR,DL,DX,PATH>,LM extends LibraryModel<S,SV,SM,A,AV,AM,L,LV,LM,DF,DK,DV,DM,DR,DL,DX,PATH>,DF extends Directory<S,SV,SM,A,AV,AM,L,LV,LM,DF,DK,DV,DM,DR,DL,DX,PATH>,DK extends DirectoryKey<S,SV,SM,A,AV,AM,L,LV,LM,DF,DK,DV,DM,DR,DL,DX,PATH>,DV extends DirectoryView<S,SV,SM,A,AV,AM,L,LV,LM,DF,DK,DV,DM,DR,DL,DX,PATH>,DM extends DirectoryModel<S,SV,SM,A,AV,AM,L,LV,LM,DF,DK,DV,DM,DR,DL,DX,PATH>,DR extends DirectoryReference<S,SV,SM,A,AV,AM,L,LV,LM,DF,DK,DV,DM,DR,DL,DX,PATH>,DL extends DirectoryLibrarian<S,SV,SM,A,AV,AM,L,LV,LM,DF,DK,DV,DM,DR,DL,DX,PATH>,DX extends DirectoryContext<S,SV,SM,A,AV,AM,L,LV,LM,DF,DK,DV,DM,DR,DL,DX,PATH>,PATH extends Comparable<PATH>> extends FileSystemProvider implements Control<A,AV,AM> {

    protected final UUID uuid = UUID.randomUUID();
    protected final Instant createTime = Instant.now();
    protected final S scheme;
    protected final Domain domain;
    protected final Integer port;
    protected final String urlString;
    protected final Map<Range<PATH>, L> rangeCatalogMap = new ConcurrentHashMap<>();
    protected final Map<String,? extends Concept<?,?,?>> classNameResourceMap = new HashMap<>();

    protected final Map<L, Bureau<?,?,?>[]> catalogMemoryMap;

    protected StringBuilder firstLimitReachedMessage(String className, long warnTotal, long hardLimit) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(className).append("warnTotal:").append(warnTotal).append(" hardLimit").append(hardLimit);
        return stringBuilder;
    }
    protected String hardLimitReached(String className, long warnTotal, long hardLimit, AtomicLong count, String previousMessage) {
        return firstLimitReachedMessage(className,warnTotal,hardLimit).append(' ').append(previousMessage).toString() ;
    }

    public Authority(S scheme, Domain domain, int port) {
        this.scheme = scheme;
        this.domain = domain;
        if (scheme.getTerrene() != domain.getTerrene()) {
            throw new RuntimeException("Terrene mismatch scheme terrene = " + scheme.getTerrene() + " doesn't match domain terrene = " + domain.getTerrene());
        }
        String urlStringTemp = this.scheme.getScheme() + this.domain.getDomainName();
        if (port == scheme.getDefaultPort()) {
            this.port = -1;
            this.urlString = urlStringTemp;
        } else {
            this.port = port;
            this.urlString = urlStringTemp + ":" + this.port;
        }
        this.catalogMemoryMap = Matrix.getInstance().getCatalogRecords(domain, scheme.getProtocolParser().getProtocol().getLabel());
    }

    @Override
    public UUID getUuid() {
        return uuid;
    }

    @Override
    public Instant getCreateInstant() {
        return createTime;
    }

    @Override
    public Matrix getMatrix() {
        return null;
    }

    public String getUrlString() {
        return this.urlString;
    }

    public Domain getDomain() {
        return domain;
    }

    public Integer getPort() {
        return port;
    }

    public String getSeparator() {
        return this.get_Scheme().getProtocolParser().getProtocol().getSeparator();
    }

    @Override
    public String getScheme() {
        return this.scheme.getScheme();
    }

    public S get_Scheme() {
        return this.scheme;
    }

    private L findCatalog(PATH filePath) {
        for (Range<PATH> range: this.rangeCatalogMap.keySet()) {
            if (range.eval(filePath)) {
                return this.rangeCatalogMap.get(range);
            }
        }
        throw new RuntimeException("Cannot find catalog for " + filePath);
    }
    @Override
    public synchronized L newFileSystem(URI uri, Map<String, ?> env) throws IOException {
        if (uri.isAbsolute() && uri.getScheme().equals(this.getScheme()) && uri.getHost().equals(this.domain.getDomainName()) && uri.getPort() == port) {
            Map<String, List<String>> queryMap = splitQuery(uri);

        }
        return null;
    }

    @Override
    public L getFileSystem(URI uri) {
        if (uri.isAbsolute() && uri.getScheme().equals(this.getScheme()) && uri.getHost().equals(this.domain.getDomainName()) && uri.getPort() == port) {

        }
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
    public Bureau<?,?,?> getFileStore(Path path) throws IOException {
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
    public Map<String, List<String>> splitQuery(URI uri) {
        if (uri.getQuery() == null || uri.getQuery().isEmpty()) {
            return Collections.emptyMap();
        }
        return Arrays.stream(uri.getQuery().split("&"))
                .map(this::splitQueryParameter)
                .collect(Collectors.groupingBy(AbstractMap.SimpleImmutableEntry::getKey, LinkedHashMap::new, Collectors.mapping(Map.Entry::getValue, Collectors.toList())));
    }

    public AbstractMap.SimpleImmutableEntry<String, String> splitQueryParameter(String it) {
        final int idx = it.indexOf("=");
        final String key = idx > 0 ? it.substring(0, idx) : it;
        final String value = idx > 0 && it.length() > idx + 1 ? it.substring(idx + 1) : null;
        return new AbstractMap.SimpleImmutableEntry<>(
                URLDecoder.decode(key, StandardCharsets.UTF_8),
                URLDecoder.decode(value, StandardCharsets.UTF_8)
        );
    }

    //protected abstract <PATH extends Comparable<PATH>,ID extends Comparable<ID>,T extends Concept.Identity<S,L,PATH,ID,T,C>,C extends Concept<S,L,PATH,ID,T,C>,CAT extends Ledger<S,L,PATH,ID,T,C,CAT>> CAT initCatalog(Memory<S,L,PATH> bureau, Pattern separatorPattern, Gathering<S,L,PATH,ID,T,C,CAT> directoriesSeed) throws CheckedException;

//    public CodeSigner[] getCodeSigners(Zone zone) {
//
//        throw new MatrixException(MatrixException.Type.CodeSigners_not_initialized,new Exception("StackTrace, should be calling getCodeSigner() only after calling getUrl()"),new IndiciaKey("getCodeSigners() failed to create CodeSigner[] needed", libraryKey.getExceptionalSeries()),new Occurrence(UUID.randomUUID(),Instant.now(), Matter.Severity.Exceptional));
//    }

    @Override
    public int compareTo(A that) {
        return this.urlString.compareTo(that.urlString);
    }
}
