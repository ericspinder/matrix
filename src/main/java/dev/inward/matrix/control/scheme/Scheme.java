/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.control.scheme;

import dev.inward.matrix.Matrix;
import dev.inward.matrix.ProtocolParser;
import dev.inward.matrix.Terrene;
import dev.inward.matrix.control.Control;
import dev.inward.matrix.control.authority.*;
import dev.inward.matrix.file.directory.*;

import java.io.IOException;
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

    protected final Map<String, Authority<DF,DK,DV,DM,DR,DL,PATH>> schemeLibraries = new ConcurrentHashMap<>();

    protected final Terrene terrene;
    protected final ProtocolParser<PATH> protocolParser;
    protected final String scheme;

    @SuppressWarnings("unchecked")
    public Scheme(Terrene terrene, ProtocolParser<PATH> protocolParser) {
        this.terrene = terrene;
        this.protocolParser = protocolParser;
        if (terrene != Terrene.Earth) {
            this.scheme = terrene.toString() + '.' + protocolParser.getProtocol().getLabel();
        }
        else {
            this.scheme = getProtocolParser().getProtocol().getLabel();
        }
    }
    @SuppressWarnings("unchecked")
    public Authority<DF,DK,DV,DM,DR,DL,PATH> findLibrary(URI uri) {
        int port = (uri.getPort() > 0) ? uri.getPort(): getDefaultPort();
        String library_cache_key = scheme + "://" + uri.getHost() + ':' + port;
        return schemeLibraries.containsKey(library_cache_key) ? schemeLibraries.get(library_cache_key): this.buildLibrary(library_cache_key,uri.getHost(),port);
    }
    @SuppressWarnings("unchecked")
    public synchronized Authority<DF,DK,DV,DM,DR,DL,PATH> buildLibrary(String library_cache_key, String host, int port) {
        if (schemeLibraries.containsKey(library_cache_key)) {
            return schemeLibraries.get(library_cache_key);
        }
        Authority<DF,DK,DV,DM,DR,DL,PATH> authority = new Authority<>(this, Matrix.getInstance().getDomain(this.terrene, host), port,this.protocolParser.getProtocol().getSeparator());
        this.schemeLibraries.put(library_cache_key, authority);
        return authority;
    }
    protected long getExceptionalSeries() {
        return 0;
    }

    public Terrene getTerrene() {
        return terrene;
    }

    public ProtocolParser<PATH> getProtocolParser() {
        return protocolParser;
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
    public int compareTo(Scheme<DF,DK,DV,DM,DR,DL,PATH> that) {
        return this.scheme.compareTo(that.scheme);
    }

    @Override
    public int getDefaultPort() {
        return this.protocolParser.getProtocol().getDefaultPort();
    }

    @Override
    public String toString() {
        return String.valueOf(terrene).toLowerCase() + '.' + scheme.toLowerCase();
    }

}
