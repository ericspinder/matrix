/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import dev.inward.matrix.file.*;

import java.io.IOException;
import java.net.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class Scheme<S extends Scheme<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,LK extends LibraryKey<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,L extends Library<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,PATH extends Comparable<PATH>,CK extends CatalogKey<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,C extends Catalog<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DK extends DirectoryKey<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,D extends Directory<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DR extends DirectoryReference<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DA extends DirectoryAttributes<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DRESOURCE extends DirectoryResource<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>,DM extends DirectoryModel<S,LK,L,PATH,CK,C,DK,D,DR,DA,DRESOURCE,DM>> extends URLStreamHandler implements Comparable<S> {

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
        L library = this.makeLibraryKey((S)this, Domain.getInstance(host), port,null).getLibrary();
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
