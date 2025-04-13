/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import dev.inward.matrix.container.catalog.*;
import dev.inward.matrix.file.*;

import java.lang.ref.WeakReference;
import java.net.URI;
import java.util.Objects;

public abstract class LibraryKey<S extends Scheme<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,LK extends LibraryKey<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,L extends Library<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,LV extends LibraryView<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,LM extends LibraryModel<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,LR extends LibraryReference<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,LG extends LibraryGestalt<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,PATH extends Comparable<PATH>,CK extends CatalogKey<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,C extends Catalog<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,CV extends CatalogView<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,CM extends CatalogModel<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,CR extends CatalogReference<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,CG extends CatalogGestalt<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,DB extends DirectoryLibrarian<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,DK extends DirectoryKey<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,D extends Directory<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,DV extends DirectoryView<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,DM extends DirectoryModel<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,DR extends DirectoryReference<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,DG extends DirectoryGestalt<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>> extends MatrixKey<LK,L,LV,LM,LR,LG> {

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

    public static abstract class Builder<S extends Scheme<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,LK extends LibraryKey<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,L extends Library<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,LV extends LibraryView<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,LM extends LibraryModel<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,LR extends LibraryReference<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,LG extends LibraryGestalt<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,PATH extends Comparable<PATH>,CK extends CatalogKey<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,C extends Catalog<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,CV extends CatalogView<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,CM extends CatalogModel<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,CR extends CatalogReference<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,CG extends CatalogGestalt<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,DB extends DirectoryLibrarian<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,DK extends DirectoryKey<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,D extends Directory<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,DV extends DirectoryView<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,DM extends DirectoryModel<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,DR extends DirectoryReference<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,DG extends DirectoryGestalt<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>> extends MatrixKey.Builder<LK,L,LV,LM,LR,LG> {

        protected S scheme;
        protected String separator = "/";
        protected Domain domain;
        protected int port = 0;

        public Builder<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG> setScheme(S scheme) {
            this.scheme = scheme;
            return this;
        }
        public Builder<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG> setSeparator(String separator) {
            this.separator = separator;
            return this;
        }
        public Builder<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG> setDomain(Domain domain) {
            this.domain = domain;
            return this;
        }
        public Builder<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG> setPort(int port) {
            this.port = port;
            return this;
        }

        @Override
        protected URI makeUri() {
            StringBuilder sb = new StringBuilder();
            sb.append(scheme.scheme).append("://").append(domain);
            if (scheme.getDefaultPort() != port && port > 0) {
                sb.append(':').append(port);
            }
            return URI.create(sb.toString());
        }

    }
}
