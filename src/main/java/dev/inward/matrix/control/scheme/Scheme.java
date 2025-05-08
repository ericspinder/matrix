/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.control.scheme;

import dev.inward.matrix.Matrix;
import dev.inward.matrix.MatrixURLStreamHandlerProvider;
import dev.inward.matrix.Terrene;
import dev.inward.matrix.control.Control;
import dev.inward.matrix.control.domain.Domain;
import dev.inward.matrix.control.library.*;
import dev.inward.matrix.file.directory.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Scheme<DF extends Directory<DF,DK,DV,DM,DR,DL,PATH>,DK extends DirectoryKey<DF,DK,DV,DM,DR,DL,PATH>,DV extends DirectoryView<DF,DK,DV,DM,DR,DL,PATH>,DM extends DirectoryModel<DF,DK,DV,DM,DR,DL,PATH>,DR extends DirectoryReference<DF,DK,DV,DM,DR,DL,PATH>,DL extends DirectoryLibrarian<DF,DK,DV,DM,DR,DL,PATH>,PATH extends Comparable<PATH>> extends URLStreamHandler implements Control<Scheme<DF,DK,DV,DM,DR,DL,PATH>,SchemeView<DF,DK,DV,DM,DR,DL,PATH>,SchemeModel<DF,DK,DV,DM,DR,DL,PATH>> {

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

    protected final Map<String, Library<PATH,DK,DF,DV,DM,DR, DL>> schemeLibraries = new ConcurrentHashMap<>();

    protected final Terrene terrene;
    protected final MatrixURLStreamHandlerProvider.Protocol protocol;
    protected final String scheme;

    @SuppressWarnings("unchecked")
    public Scheme(Terrene terrene, MatrixURLStreamHandlerProvider.Protocol protocol) {
        this.terrene = terrene;
        this.protocol = protocol;
        if (terrene != Terrene.Earth) {
            this.scheme = terrene.toString() + '.' + protocol.getLabel();
        }
        else {
            this.scheme = protocol.getLabel();
        }
    }
    @SuppressWarnings("unchecked")
    public Library<PATH,DK,DF,DV,DM,DR, DL> findLibrary(URI uri) {
        int port = (uri.getPort() > 0) ? uri.getPort(): getDefaultPort();
        String library_cache_key = scheme + "://" + uri.getHost() + ':' + port;
        return schemeLibraries.containsKey(library_cache_key) ? schemeLibraries.get(library_cache_key): this.buildLibrary(library_cache_key,uri.getHost(),port);
    }
    @SuppressWarnings("unchecked")
    public synchronized Library<PATH,DK,DF,DV,DM,DR, DL> buildLibrary(String library_cache_key, String host, int port) {
        if (schemeLibraries.containsKey(library_cache_key)) {
            return schemeLibraries.get(library_cache_key);
        }
        Library<PATH,DK,DF,DV,DM,DR, DL> library = new Library() {
        }this.makeLibrary((S)this, Matrix.getInstance().getDomain(this.terrene, host), port,this.protocol.getSeparator());
        this.schemeLibraries.put(library_cache_key, library);
        return library;
    }
    protected long getExceptionalSeries() {
        return 0;
    }

    protected L makeLibrary(S scheme,Domain domain, int port,String separator) {
        try {
            return this.libraryClass.getDeclaredConstructor(Scheme.class,Domain.class, Integer.class, String.class).newInstance(scheme,domain,port,separator);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
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
