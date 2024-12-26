package dev.inward.matrix;

import dev.inward.matrix.code.Scheme_ofCode;
import dev.inward.matrix.dns.Scheme_ofDNS;
import dev.inward.matrix.http.Scheme_ofHttp;
import dev.inward.matrix.https.Scheme_ofHttps;
import dev.inward.matrix.log.Scheme_ofLog;

import java.io.IOException;
import java.net.*;
import java.util.HashMap;
import java.util.Map;

public abstract class Scheme<S extends Scheme<S,L,PATH>,L extends Library<S,L,PATH>,PATH extends Comparable<PATH>> extends URLStreamHandler implements Comparable<S> {


    protected static Map<String,Scheme<?,?,?>> ALL_KNOW_SCHEMES = new HashMap<>();
    protected static Map<String,Library<?,?,?>> ALL_FOUND_LIBRARIES = new HashMap<>();
    public static Scheme<?,?,?> findSchemeByString(String scheme_s) {
        Scheme<?,?,?> scheme = ALL_KNOW_SCHEMES.get(scheme_s);
        if (scheme == null && scheme_s.indexOf('.') == -1) {
            scheme = ALL_KNOW_SCHEMES.get(Terrene.Earth.toString() + '_' + scheme_s);
        }
        return scheme;
    }
    public static Library<?,?,?> findLibrary(URI uri,Scheme<?,?,?> scheme) {
        String authority = scheme.terrene.toString() + '.' + scheme.scheme + ((uri.getPort() == -1) ? uri.getAuthority(): uri.getHost() + ':' + scheme.defaultPort);
        return ALL_FOUND_LIBRARIES.containsKey(authority) ? ALL_FOUND_LIBRARIES.get(authority): scheme.buildNewLibrary(uri);
    }

    public enum Protocol implements Meta_I {
        CODE("code","Code Repository",8, Scheme_ofCode.class),
        DNS("dns","Domain Name System",53, Scheme_ofDNS.class),
        HTTP("http","Unsecure File Service", 80, Scheme_ofHttp.class),
        HTTPS("https","Secure File Service",443, Scheme_ofHttps.class),
        LOG("log","Completed Matters",10, Scheme_ofLog.class),
        ;
        private final String label;
        private final String description;
        private final int defaultPort;

        private final Class<? extends Scheme<?,?,?>> schemeClass;
        Protocol(final String label, final String description, int defaultPort,Class<? extends Scheme<?,?,?>> schemeClass) {
            this.label = label;
            this.description = description;
            this.defaultPort = defaultPort;
            this.schemeClass = schemeClass;
        }
        Protocol valueOfIgnoreCase(String protocolString) {
            return Protocol.valueOf(protocolString.toUpperCase());
        }


        @Override
        public final String getLabel() {
            return this.label;
        }

        @Override
        public final String getDescription() {
            return this.description;
        }

        public int getDefaultPort() {
            return defaultPort;
        }

        public Class<? extends Scheme<?, ?, ?>> getSchemeClass() {
            return schemeClass;
        }
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
    protected final Protocol protocol;
    protected final String scheme;
    protected final int defaultPort;

    protected Scheme(String scheme) {
        this.terrene = Terrene.Parse(scheme.substring(0,scheme.lastIndexOf(".")));
        this.protocol = Protocol.valueOf(scheme.substring(scheme.lastIndexOf(".")));
        this.scheme = scheme;
        this.defaultPort = protocol.defaultPort;
    }
    protected Scheme(Terrene terrene,Protocol protocol) {
        this.terrene = terrene;
        this.protocol = protocol;
        this.scheme = terrene.toString() + '.' + protocol;
        this.defaultPort = protocol.defaultPort;
        ALL_KNOW_SCHEMES.put(terrene.toString() + '_' + protocol,this);
    }

    public Terrene getTerrene() {
        return terrene;
    }

    public Protocol getProtocol() {
        return protocol;
    }

    public String getScheme() {
        return scheme;
    }

    public abstract L buildNewLibrary(URI uri);

    @SuppressWarnings("unchecked")
    protected Clerk.Network.Client obtainClerk(URL u) throws IOException {
        try {
            return Domain.getInstance(Terrene..toURI().getHost()).getLibrary((S)this).getClient(u.toURI());
        } catch (URISyntaxException e) {
            throw new IOException(e);
        }
    }

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
