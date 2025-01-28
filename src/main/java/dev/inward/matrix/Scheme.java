package dev.inward.matrix;

import java.io.IOException;
import java.net.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class Scheme<S extends Scheme<S,L,PATH>,L extends Library<S,L,PATH>,PATH extends Comparable<PATH>> extends URLStreamHandler implements Comparable<S> {

    private final Map<String, Library<S,L,PATH>> schemeLibraries = new ConcurrentHashMap<>();
    @SuppressWarnings("unchecked")
    public L findLibrary(URI uri) {
        int port = (uri.getPort() > 0) ? uri.getPort(): getDefaultPort();
        String library_key = scheme + "://" + uri.getHost() + ':' + port;
        return schemeLibraries.containsKey(library_key) ? (L) schemeLibraries.get(library_key): this.buildNewLibrary(library_key,uri.getHost(),port);
    }
    @SuppressWarnings("unchecked")
    public synchronized L buildNewLibrary(String library_key,String host,int port) {
        if (schemeLibraries.containsKey(library_key)) {
            return (L) schemeLibraries.get(library_key);
        }
        L newLibrary = this.buildNewLibrary(Domain.getInstance(host),port);
        this.schemeLibraries.put(library_key, newLibrary);
        return newLibrary;
    }
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

    protected Scheme(String scheme) {
        this.terrene = Terrene.Parse(scheme.substring(0,scheme.lastIndexOf(".")));
        this.protocol = MatrixURLStreamHandlerProvider.Protocol.valueOf(scheme.substring(scheme.lastIndexOf(".")));
        this.scheme = scheme;
    }
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
    protected abstract L buildNewLibrary(Domain domain, int port);

//    @SuppressWarnings("unchecked")
//    protected Clerk.Network.Client obtainClerk(URL u) throws IOException {
//        try {
//            return Domain.getInstance(Terrene.Parse(u.getProtocol()),u.getHost());
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
        final StringBuilder sb = new StringBuilder("Scheme{");
        sb.append("terrene=").append(terrene);
        sb.append(", scheme='").append(scheme).append('\'');
        sb.append(", defaultPort=").append(this.protocol.getDefaultPort());
        sb.append('}');
        return sb.toString();
    }

}
