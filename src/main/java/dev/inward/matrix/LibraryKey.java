/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import dev.inward.matrix.file.*;

import java.lang.ref.WeakReference;
import java.net.URI;
import java.nio.file.Watchable;
import java.util.Objects;

public abstract class LibraryKey<S extends Scheme<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,LK extends LibraryKey<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,L extends Library<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,PATH extends Comparable<PATH>,CK extends CatalogKey<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,C extends Catalog<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DK extends DirectoryKey<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,D extends Directory<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DR extends DirectoryReference<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DA extends DirectoryAttributes<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DRESOURCE extends DirectoryResource<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DM extends DirectoryModel<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>> extends MatrixKey<LK,L> implements Watchable, Comparable<LK> {

    protected final S scheme;
    protected final Domain domain;
    protected final Integer port;
    protected final String separator;
    protected WeakReference<L> libraryWeakReference;

    protected LibraryKey(URI uri, S scheme, Domain domain, int port, String separator) {
        super(uri);
        this.scheme = scheme;
        this.domain = domain;
        if (port == scheme.getDefaultPort()) {
            this.port = -1;
        } else {
            this.port = port;
        }
        this.separator = Objects.requireNonNullElse(separator, "/");
    }
    public S getScheme() {
        return scheme;
    }

    public Domain getDomain() {
        return domain;
    }

    public Integer getPort() {
        return port;
    }

    public String getSeparator() {
        return separator;
    }

    @SuppressWarnings("unchecked")
    public L getLibrary() {
        if (this.libraryWeakReference == null || this.libraryWeakReference.get() == null) {
            L library = scheme.buildLibrary((LK)this);
            this.libraryWeakReference = new WeakReference<>(library);
            return library;
        }
        return (L) this.libraryWeakReference.get();
    }

    public long getExceptionalSeries() {
        return 0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(scheme.toString()).append("://").append(domain.toString());
        if (port > 0) {
            stringBuilder.append(':').append(port);
        }
        return stringBuilder.toString();
    }


    @Override
    public int compareTo(LK that) {
        int isZero = this.domain.compareTo(that.domain);
        if (isZero == 0) {
            isZero = Integer.compare(this.port, that.port);
            if (isZero == 0) {
                return this.scheme.compareTo(that.scheme);
            }
        }
        return isZero;
    }
    public static abstract class Builder<S extends Scheme<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,LK extends LibraryKey<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,L extends Library<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,PATH extends Comparable<PATH>,CK extends CatalogKey<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,C extends Catalog<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DK extends DirectoryKey<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,D extends Directory<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DR extends DirectoryReference<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DA extends DirectoryAttributes<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DRESOURCE extends DirectoryResource<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DM extends DirectoryModel<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>> {

        private URI uri;
        private S scheme;
        private String separator;
        private Domain domain;
        private int port;

        Builder<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM> buildUri(S scheme, Domain domain, int port, String separator) {
            StringBuilder sb = new StringBuilder();
            sb.append(scheme.scheme).append("://").append(domain);
            if (scheme.getDefaultPort() != port && port > 0) {
                sb.append(':').append(port);
            }
            this.uri = URI.create(sb.toString());
            this.scheme = scheme;
            this.domain = domain;
            this.port = port;
            if (separator != null && !separator.isEmpty()) {
                this.separator = separator;
            }
            else {
                this.separator = "/";
            }
            return this;
        }
        public abstract L buildLibraryKey();
    }
}
