package dev.inward.matrix;

import dev.inward.matrix.director.library.Director;
import dev.inward.matrix.concept.matter.Indicia;

import java.io.IOException;
import java.net.*;
import java.util.concurrent.ConcurrentHashMap;

public class Scheme<S extends Scheme<S,L,PATH>,L extends Library<S,L,PATH>,PATH extends Comparable<PATH>> extends URLStreamHandler implements Comparable<S> {

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
    protected final Protocol<PATH> protocol;
    protected final String scheme;
    protected final int defaultPort;

    protected Scheme(String scheme, int defaultPort) {
        this.terrene = Terrene.Parse(scheme.substring(0,scheme.lastIndexOf(".")));
        this.protocol = Protocol.GetProtocol(scheme.substring(scheme.lastIndexOf(".")));
        this.scheme = scheme;
        this.defaultPort = defaultPort;
    }


    @SuppressWarnings("unchecked")
    protected Clerk.Network.Client obtainClerk(URL u) throws IOException {
        try {
            return Domain.getInstance(u.toURI().getHost()).getLibrary((S)this).getClient(this, u);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected URLConnection openConnection(URL u) throws IOException {
        return null;
    }

    @Override
    protected URLConnection openConnection(URL u, Proxy p) throws IOException {
        return super.openConnection(u, p);
    }

    @Override
    public int compareTo(Scheme that) {
        return this.scheme.compareTo(that.scheme);
    }

    @Override
    public int getDefaultPort() {
        return defaultPort;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Scheme{");
        sb.append("terrene=").append(terrene);
        sb.append(", scheme='").append(scheme).append('\'');
        sb.append(", defaultPort=").append(defaultPort);
        sb.append(", domainStringLibraryMap=").append(domainStringLibraryMap);
        sb.append('}');
        return sb.toString();
    }
}
