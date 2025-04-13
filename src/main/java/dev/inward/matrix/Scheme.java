/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import dev.inward.matrix.container.catalog.*;
import dev.inward.matrix.container.domain.Domain;
import dev.inward.matrix.container.domain.DomainKey;
import dev.inward.matrix.container.library.*;
import dev.inward.matrix.file.*;

import java.io.IOException;
import java.net.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class Scheme<S extends Scheme<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,LK extends LibraryKey<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,L extends Library<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,LV extends LibraryView<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,LM extends LibraryModel<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,LR extends LibraryReference<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,LG extends LibrarySteward<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,PATH extends Comparable<PATH>,CK extends CatalogKey<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,C extends Catalog<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,CV extends CatalogView<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,CM extends CatalogModel<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,CR extends CatalogReference<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,CG extends CatalogSteward<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,DB extends DirectoryLibrarian<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,DK extends DirectoryKey<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,D extends Directory<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,DV extends DirectoryView<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,DM extends DirectoryModel<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,DR extends DirectoryReference<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>,DG extends DirectorySteward<S,LK,L,LV,LM,LR,LG,PATH,CK,C,CV,CM,CR,CG,DB,DK,D,DV,DM,DR,DG>> extends URLStreamHandler implements Comparable<S> {

    protected final Map<String, L> schemeLibraries = new ConcurrentHashMap<>();

    @SuppressWarnings("unchecked")
    public L findLibrary(URI uri) {
        int port = (uri.getPort() > 0) ? uri.getPort(): getDefaultPort();
        String library_cache_key = scheme + "://" + uri.getHost() + ':' + port;
        return schemeLibraries.containsKey(library_cache_key) ? (L) schemeLibraries.get(library_cache_key): this.buildLibrary(library_cache_key,uri.getHost(),port);
    }
    @SuppressWarnings("unchecked")
    public synchronized L buildLibrary(String library_cache_key, String host, int port) {
        if (schemeLibraries.containsKey(library_cache_key)) {
            return (L) schemeLibraries.get(library_cache_key);
        }
        DomainKey domainKey = (new DomainKey.Builder()).setDomainName(host).setTerrene(this.terrene).buildMatrixKey();
        L library = this.makeLibraryKey((S)this, Domain.getInstance(this.terrene, host), port,null).getLibrary();
        this.schemeLibraries.put(library_cache_key, library);
        return library;
    }
    protected long getExceptionalSeries() {
        return 0;
    }

    protected abstract LK makeLibraryKey(S scheme,Domain domain, int port,String separator);
    protected abstract L buildLibrary(LK libraryKey);
    public enum Reserved {
        Semicolon(';'),
        Slash('/'),
        Query('?'),
        Colon(':'),
        At('@'),
        And('&'),
        Equal('='),
        Plus('+'),
        Dollar('$'),
        Comma(','),
        Bracket_Open('['),
        Bracket_Close(']'),
        ;
        final char reserved;
        Reserved(char reserved) {
            this.reserved = reserved;
        }

        public char getReserved() {
            return reserved;
        }
    }
    public enum Unwise {
        Parentheses_Open('{'),
        Parentheses_Close('}'),
        Pipe('|'),
        BackSlash('\\'),
        Hat('^'),
        Grave('`'),
        ;
        final char unwise;

        Unwise(char unwise) {
            this.unwise = unwise;
        }

        public char getUnwise() {
            return unwise;
        }
    }

    protected final Terrene terrene;
    protected final MatrixURLStreamHandlerProvider.Protocol protocol;
    protected final String scheme;

    public Scheme(Terrene terrene, MatrixURLStreamHandlerProvider.Protocol protocol) {
        this.terrene = terrene;
        this.protocol = protocol;
        this.scheme = terrene.toString() + '.' + protocol;
    }

    public Terrene getTerrene() {
        return terrene;
    }

    public MatrixURLStreamHandlerProvider.Protocol getProtocol() {
        return protocol;
    }

    public String getScheme() {
        return scheme;
    }

//    @SuppressWarnings("unchecked")
//    protected Clerk.Network.Client obtainClerk(URL u) throws IOException {
//        try {
//
//        } catch (URISyntaxException e) {
//            throw new IOException(e);
//        }
//    }

    @Override
    protected URLConnection openConnection(URL u) throws IOException {
        throw new IOException("URLConnection not available use obtainClerk(URL url)");
    }

    @Override
    protected URLConnection openConnection(URL u, Proxy p) throws IOException {
        throw new IOException("URLConnection not available use obtainClerk(URL url)");
    }
    @Override
    public int compareTo(Scheme that) {
        return this.scheme.compareTo(that.scheme);
    }

    @Override
    public int getDefaultPort() {
        return this.protocol.getDefaultPort();
    }

    @Override
    public String toString() {
        return String.valueOf(terrene).toLowerCase() + '.' + scheme.toLowerCase();
    }

}
