/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */


package dev.inward.matrix.concept.fact;

import dev.inward.matrix.Context;
import dev.inward.matrix.concept.fact.directory.Directory;
import dev.inward.matrix.concept.fact.directory.DirectoryKey;
import dev.inward.matrix.control.authority.*;
import dev.inward.matrix.control.library.Library;
import dev.inward.matrix.concept.fact.addressed.AddressedKey;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.*;
import java.util.*;

public abstract class FactKey<F extends Fact<F,K,V,M,L,X>,K extends FactKey<F,K,V,M,L,X>,V extends FactView<F,K,V,M,L,X>,M extends FactModel<F,K,V,M,L,X>,L extends Librarian<F,K,V,M,L,X>,X extends FactContext<F,K,V,M,L,X>> implements Path {

    transient private Cabin<F,K,V,M,L,X> cabin;
    protected final String url;

    protected FactKey(URI uri) {
        this.url = this.processUri(uri).toString();
    }
    public final Cabin<F,K,V,M,L,X> getCabin() {
        return this.cabin;
    }
    public final void setCabin(Cabin<F,K,V,M,L,X> cabin) {
        if (this.cabin != null && Objects.requireNonNull(cabin.get()).key == this) {
            this.cabin = cabin;
        } else {
            throw new RuntimeException("Unable to reset reference, cabin already set");
        }
    }
    protected abstract URL processUri(URI uri);


    @NotNull
    @Override
    public Library<?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?> getFileSystem() {
        if (cabin != null && Objects.requireNonNull(cabin.get()).key == this) {
            if (this.cabin != null && Objects.requireNonNull(cabin.get()).key == this) {
                return this.getCabin().get().getLibrarian().getCatalog().getLibrary();
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
        FactKey<?, ?, ?, ?, ?, ?> factKey = (FactKey<?, ?, ?, ?, ?, ?>) this;
        this.getFileSystem().getRootDirectories();
        return this;
    }

    @Override
    public Path getFileName() {
        return this;
    }

    @Override
    public Path getParent() {
        return null;
    }

    @Override
    public int getNameCount() {
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

    @NotNull
    @Override
    public Path resolve(@NotNull Path other) {
        return null;
    }

    @Override
    public Path relativize(Path other) {
        return null;
    }

    @NotNull
    @Override
    public URI toUri() {
        try {
            return new URI(url);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
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
            return this.url.compareTo(that.url);
        }
        return -1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FactKey<?,?,?,?,?,?> that = (FactKey<?,?,?,?,?,?>) o;
        return Objects.equals(url, that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url);
    }

    @NotNull
    @Override
    public String toString() {
        return this.url;
    }

}
