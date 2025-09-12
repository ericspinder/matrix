/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.control.scheme;

import dev.inward.matrix.Matrix;
import dev.inward.matrix.ProtocolParser;
import dev.inward.matrix.Terrene;
import dev.inward.matrix.control.authority.*;
import dev.inward.matrix.control.library.Library;
import dev.inward.matrix.control.library.LibraryModel;
import dev.inward.matrix.control.library.LibraryView;
import dev.inward.matrix.file.directory.*;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.net.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class Scheme<S extends Scheme<S,SV,SM,A,AV,AM,L,LV,LM,DF,DK,DV,DM,DR,DL,DX,PATH>,SV extends SchemeView<S,SV,SM,A,AV,AM,L,LV,LM,DF,DK,DV,DM,DR,DL,DX,PATH>,SM extends SchemeModel<S,SV,SM,A,AV,AM,L,LV,LM,DF,DK,DV,DM,DR,DL,DX,PATH>,A extends Authority<S,SV,SM,A,AV,AM,L,LV,LM,DF,DK,DV,DM,DR,DL,DX,PATH>,AV extends AuthorityView<S,SV,SM,A,AV,AM,L,LV,LM,DF,DK,DV,DM,DR,DL,DX,PATH>,AM extends AuthorityModel<S,SV,SM,A,AV,AM,L,LV,LM,DF,DK,DV,DM,DR,DL,DX,PATH>,L extends Library<S,SV,SM,A,AV,AM,L,LV,LM,DF,DK,DV,DM,DR,DL,DX,PATH>,LV extends LibraryView<S,SV,SM,A,AV,AM,L,LV,LM,DF,DK,DV,DM,DR,DL,DX,PATH>,LM extends LibraryModel<S,SV,SM,A,AV,AM,L,LV,LM,DF,DK,DV,DM,DR,DL,DX,PATH>,DF extends Directory<S,SV,SM,A,AV,AM,L,LV,LM,DF,DK,DV,DM,DR,DL,DX,PATH>,DK extends DirectoryKey<S,SV,SM,A,AV,AM,L,LV,LM,DF,DK,DV,DM,DR,DL,DX,PATH>,DV extends DirectoryView<S,SV,SM,A,AV,AM,L,LV,LM,DF,DK,DV,DM,DR,DL,DX,PATH>,DM extends DirectoryModel<S,SV,SM,A,AV,AM,L,LV,LM,DF,DK,DV,DM,DR,DL,DX,PATH>,DR extends DirectoryReference<S,SV,SM,A,AV,AM,L,LV,LM,DF,DK,DV,DM,DR,DL,DX,PATH>,DL extends DirectoryLibrarian<S,SV,SM,A,AV,AM,L,LV,LM,DF,DK,DV,DM,DR,DL,DX,PATH>,DX extends DirectoryContext<S,SV,SM,A,AV,AM,L,LV,LM,DF,DK,DV,DM,DR,DL,DX,PATH>,PATH extends Comparable<PATH>> extends URLStreamHandler implements Comparable<S> {

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
    protected final Class<A> authorityClass;

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
        authorityClass = (Class<A>)((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[3];
    }
    @SuppressWarnings("unchecked")
    public A findLibrary(URI uri) {
        int port = (uri.getPort() > 0) ? uri.getPort(): getDefaultPort();
        String library_cache_key = scheme + "://" + uri.getHost() + ':' + port;
        return schemeLibraries.containsKey(library_cache_key) ? schemeLibraries.get(library_cache_key): this.buildLibrary(library_cache_key,uri.getHost(),port);
    }
    @SuppressWarnings("unchecked")
    public synchronized A buildLibrary(String library_cache_key, String host, int port) {
        if (schemeLibraries.containsKey(library_cache_key)) {
            return schemeLibraries.get(library_cache_key);
        }
        A authority = authorityClass.getConstructor()this, Matrix.getInstance().getDomain(this.terrene, host), port);
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
    public int compareTo(S that) {
        int isZero = this.terrene.compareTo(that.getTerrene());
        if (isZero == 0) {
            return this.scheme.compareTo(that.scheme);
        }
        return isZero;
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
