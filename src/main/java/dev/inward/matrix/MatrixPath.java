/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import dev.inward.matrix.file.DirectoryKey;
import dev.inward.matrix.file.FileKey;
import dev.inward.matrix.file.addressed.AddressedKey;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.URI;
import java.nio.file.*;
import java.util.Objects;

public class MatrixPath<PATH extends Comparable<PATH>,K extends MatrixKey<PATH,K,I>,I extends MatrixItem<PATH,K,I>> implements Path {

    protected final WeakReference<K> keyReference;
    protected final URI uri;
    public MatrixPath(URI uri, K key) {
        this.uri = uri;
        this.keyReference = new WeakReference<>(key);
    }
    @Override
    public FileSystem getFileSystem() {
        if (keyReference.get() instanceof FileKey<?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?>) {
            return ((FileKey<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?>) keyReference.get()).getCatalog();
        }
        return null;
    }

    @Override
    public boolean isAbsolute() {
        return true;
    }

    @Override
    public Path getRoot() {
        if (keyReference.get() instanceof FileKey<?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?>) {
            return ((FileKey<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?>) keyReference.get()).getLibrary().getKey().getMatrixPath();
        }
        if (keyReference.get() instanceof CatalogKey<?,?,?,?,?,?,?,?,?,?,?,?>) {
            return ((CatalogKey<?,?,?,?,?,?,?,?,?,?,?,?>) keyReference.get()).getMatrixPath();
        }
        return this;
    }

    @Override
    public Path getFileName() {
        if (keyReference.get() instanceof AddressedKey<?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?>) {
            return this;
        }
        return null;
    }

    @Override
    public Path getParent() {
        if (keyReference.get() instanceof AddressedKey<?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?> addressedKey) {
            return addressedKey.getDirectoryKey().getMatrixPath();
        }
        if (keyReference.get() instanceof DirectoryKey<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> directoryKey) {
            return directoryKey.getCatalog().findDirectoryPath(directoryKey.getFilePath()).getMatrixPath();
        }
        if (keyReference.get() instanceof CatalogKey<?,?,?,?,?,?,?,?,?,?,?,?>) {
            return ((CatalogKey<?,?,?,?,?,?,?,?,?,?,?,?>) keyReference.get()).getLibrary().getKey().getMatrixPath();
        }
        return null;
    }

    @Override
    public int getNameCount() {
        if (keyReference.get() instanceof AddressedKey<?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?> addressedKey) {
             return addressedKey.getDirectoryKey().getMatrixPath().getNameCount() + 1;


        }
        if (keyReference.get() instanceof DirectoryKey<?,?,?,?,?,?,?,?,?,?,?,?> directoryKey) {
            return directoryKey.getFilePath().toString().split("/").length;
        }
        return 0;
    }

    @Override
    public Path getName(int index) {
        return null;
    }

    @Override
    public Path subpath(int beginIndex, int endIndex) {
        return null;
    }

    @Override
    public boolean startsWith(Path other) {
        return false;
    }

    @Override
    public boolean endsWith(Path other) {
        return false;
    }

    @Override
    public Path normalize() {
        return this;
    }

    @Override
    public Path resolve(Path other) {
        return null;
    }

    @Override
    public Path relativize(Path other) {
        return null;
    }

    @Override
    public URI toUri() {
        return this.uri;
    }

    @Override
    public Path toAbsolutePath() {
        return this;
    }

    @Override
    public Path toRealPath(LinkOption... options) throws IOException {
        return this;
    }

    @Override
    public WatchKey register(WatchService watcher, WatchEvent.Kind<?>[] events, WatchEvent.Modifier... modifiers) throws IOException {
        return this.keyReference.get().register(watcher, events, modifiers);
    }

    @Override
    public int compareTo(Path other) {
        if (other instanceof MatrixPath<?,?,?> that) {
            return this.uri.compareTo(that.uri);
        }
        return -1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatrixPath<?, ?, ?> that = (MatrixPath<?, ?, ?>) o;
        return Objects.equals(uri, that.uri);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uri);
    }

    @Override
    public String toString() {
        return this.uri.toString();
    }
}
