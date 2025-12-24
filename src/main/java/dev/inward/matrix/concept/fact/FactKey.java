/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */


package dev.inward.matrix.concept.fact;

import dev.inward.matrix.Aspect;
import dev.inward.matrix.Context;
import dev.inward.matrix.Seat;
import dev.inward.matrix.concept.fact.directory.Directory;
import dev.inward.matrix.concept.fact.directory.DirectoryKey;
import dev.inward.matrix.control.authority.*;
import dev.inward.matrix.control.library.Library;
import dev.inward.matrix.concept.fact.addressed.AddressedKey;
import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.reflect.ParameterizedType;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

public abstract class FactKey<F extends Fact<F,K,V,M,L,X>,K extends FactKey<F,K,V,M,L,X>,V extends FactView<F,K,V,M,L,X>,M extends FactModel<F,K,V,M,L,X>,L extends Librarian<F,K,V,M,L,X>,X extends FactContext<F,K,V,M,L,X>> implements Path {

    private Cabin<F,K,V,M,L,X> reference;
    protected final String url;

    protected FactKey(URI uri, M model) {
        this.url = this.processUri(uri).toString();
    }
    public final Cabin<F,K,V,M,L,X> getReference() {
        return this.reference;
    }
    public final void setReference(Cabin<F,K,V,M,L,X> reference) {
        if (this.reference != null && Objects.requireNonNull(reference.get()).key == this) {
            this.reference = reference;
        } else {
            throw new RuntimeException("Cannot reset reference");
        }
    }
    protected abstract URL processUri(URI uri);


    @Override
    public Library<?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?> getFileSystem() {
        if (reference != null && Objects.requireNonNull(reference.get()).key == this) {
            if (this.reference != null && Objects.requireNonNull(reference.get()).key == this) {
                return this.getReference().get().getLibrarian().getCatalog().getLibrary();
            }
        }
        throw  new RuntimeException("Cannot get file system");
    }

    @Override
    public boolean isAbsolute() {
        return true;
    }

    @Override
    public Path getRoot() {
        if (this instanceof FactKey<?,?,?,?,?,?> factKey) {
            this.getFileSystem().getRootDirectories();
        }
        return this;
    }

    @Override
    public Path getFileName() {
        return this;
    }

    @Override
    public Path getParent() {
        if (this instanceof AddressedKey<?,?,?,?,?,?,?,?,?,?,?,?,?,?> addressedKey) {
            return addressedKey.getDirectoryKey();
        }
        if (this instanceof DirectoryKey<?,?,?,?,?,?,?,?> directoryKey) {
            Directory<?,?,?,?,?,?,?,?> directory = directoryKey.reference.get();
            if (directory != null) {
                return this.reference.get().getContext().getCatalog().findDirectoryKey(directoryKey.getParentPathString());
            }
        }
        return null;
    }

    @Override
    public int getNameCount() {
        if (this instanceof AddressedKey<?,?,?,?,?,?,?,?,?,?,?,?,?,?> addressedKey) {
            return addressedKey.getDirectoryKey().getNameCount() + 1;
        }
        if (this instanceof DirectoryKey<?,?,?,?,?,?,?> directoryKey) {
            return directoryKey.directoryPath.toString().split("/").length;
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
    public int compareTo(Path other) {
        if (other instanceof FactKey<?,?,?,?,?,?> that) {
            return this.uri.compareTo(that.uri);
        }
        return -1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FactKey<?,?,?,?,?,?> that = (FactKey<?,?,?,?,?,?>) o;
        return Objects.equals(uri.toString(), that.uri.toString());
    }

    @Override
    public int hashCode() {
        return Objects.hash(uri);
    }

    @Override
    public String toString() {
        return this.uri.toString();
    }

    public static abstract class Builder<F extends Fact<F,K,V,M,L,X>,K extends FactKey<F,K,V,M,L,X>,V extends FactView<F,K,V,M,L,X>,M extends FactModel<F,K,V,M,L,X>,L extends Librarian<F,K,V,M,L,X>,X extends Context<?,?,?,?>> {

        protected URI uri;
        protected A authority;

        public Builder<F,K,V,M,R,L> setLibrary(Authority<?,?,?,?,?,?,?> authority) {
            this.authority = authority;
            return this;
        }
        protected abstract String completeUri() throws URISyntaxException;
        public final synchronized K buildMatrixKey() {
            try {
                this.uri = new URI(authority.getUrlString() + completeUri());
                return this.newMatrixKey();
            }
            catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
        }
        protected abstract K newMatrixKey();

        @SuppressWarnings("unchecked")
        protected Class<K> getFileKeyClass() {
            return (Class<K>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        }
    }
}
