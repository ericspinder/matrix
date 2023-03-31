package dev.inward.matrix.engine;

import dev.inward.matrix.authority.Domain;
import dev.inward.matrix.fact.Fact;
import dev.inward.matrix.fact.Factory;
import dev.inward.matrix.fact.Operational;
import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.Context;
import dev.inward.matrix.fact.authoritative.notion.authority.Clerk;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.spi.FileSystemProvider;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Zone<Z extends Zone<Z>> extends FileSystemProvider {

    protected final Map<Domain, Clerk<?>> domainLogMap = new ConcurrentHashMap<>();

    public static class InSituDefault extends Zone<InSituDefault> {

        public InSituDefault() {
            super(Purpose.InSitu);
        }


    }

    protected final Purpose purpose;

    public Zone(Purpose purpose) {
        this.purpose = purpose;
    }
    public <F extends Fact<F, I, ID, X>, I extends Identity<I, ID, X>, ID extends Comparable<ID>, X extends Context<X>,O extends Operational<F,I,ID,X>> Factory<F,I,ID,X,O> get() {

    }
    public Purpose getPurpose() {
        return this.purpose;
    }
    public URL createUrl(Domain domain) {
        URL url = null;
        try {
            url = new URL(domain.toString());
        }
        catch (MalformedURLException mue) {

        }
        if (url != null) {

        }
        return url;
    }

    @Override
    public String getScheme() {
        return null;
    }

    @Override
    public L newFileSystem(URI uri, Map<String, ?> env) throws IOException {
        return null;
    }

    @Override
    public L getFileSystem(URI uri) {
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
}
