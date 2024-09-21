package dev.inward.matrix;

import dev.inward.matrix.director.library.Director;
import dev.inward.matrix.concept.matter.Indicia;

import java.io.IOException;
import java.net.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class Scheme<S extends Scheme<S>> extends URLStreamHandler implements Comparable<S> {

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


    protected final String scheme;
    protected final Terrene terrene;
    protected final Map<String,Director<S,L,?,?>> directors = new ConcurrentHashMap<>();
    protected volatile transient Director<S,L,?,?> defaultNewLibrary;

    protected Scheme(String scheme,Terrene terrene) {
        this.scheme = scheme;
        this.terrene = terrene;
    }


    @Override
    protected ConceptConnection<S,L,?,?,?,?> openConnection(URL u) throws IOException {
        if (!u.getProtocol().equalsIgnoreCase(this.scheme))
            throw new MatrixException(MatrixException.Type.NotRightScheme, u.getProtocol() + " scheme_wrong", Indicia.Focus.Assembly, Indicia.Severity.Critical, new Exception("stacktrace..."));
        try {
            URI uri = u.toURI();
            uri.getSchemeSpecificPart();

        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        Director<S, L, ?, ?> director = this.directors.get(u.getAuthority());
        if (director == null) {
            director = this.getNewDirector(u.getAuthority());
        }

        // is it a Server or Client connection?
        // get DNS info
        // init library
        // init user(anonymous and userInfo if it exists)/catalogs/librarians
        // init notions/facts/etc
        return director.getRoad().
    }
    protected abstract Director<S,L,?,?> getNewDirector(String authority);

    @Override
    public int compareTo(S that) {
        return this.scheme.compareTo(that.scheme);
    }

}
