package dev.inward.matrix;

import dev.inward.matrix.director.library.Director;
import dev.inward.matrix.concept.matter.Indicia;

import java.io.IOException;
import java.net.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class Scheme<S extends Scheme<S,L>,L extends Library<S,L>> extends URLStreamHandler implements Comparable<S> {


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

    public static Scheme parseScheme(String terreneScheme) {
        if (terreneScheme.contains(".")) {
            String[] parsed = terreneScheme.split("\\.");
            Terrene terrene = Terrene.KnownWorlds.get(parsed[0]);
            if (terrene != null) {
                return terrene
            }
            return null;
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

    public static class DNS extends Scheme<DNS,Library.DNS> {
        public final static DNS Earth = new DNS(Terrene.Earth);
        public final static DNS Luna = new DNS(Terrene.Luna);

//        private final Map<Director<DNS,Librarian.DNS,Librarian<DNS,Library.DNS,?,?>> librarianMap = new WeakHashMap<>();
        private DNS(Terrene terrene) {
            super("dns",terrene);
        }

        @Override
        protected Director<DNS, Library.DNS, ?, ?> getNewDirector(String authority) {
            return null;
        }

//        protected Director<DNS, Library.DNS,>
    }
    public static class HTML extends Scheme<HTML,Library.HTML> {
        public final static HTML Earth = new HTML(Terrene.Earth);
        public final static HTML Luna = new HTML(Terrene.Luna);
        private HTML(Terrene terrene) {
            super("html",terrene);
        }

        @Override
        protected Director<HTML, Library.HTML, ?, ?> getNewDirector(String authority) {
            return null;
        }
    }
    public static class Dogma extends Scheme<Dogma, Library.Dogma> {

        public static final Dogma Earth = new Dogma(Terrene.Earth);
        public static final Dogma Luna = new Dogma(Terrene.Luna);
        protected Dogma(Terrene terrene) {
            super("dogma",terrene);
        }


        @Override
        protected Director<Dogma, Library.Dogma, ?, ?> getNewDirector(String authority) {
            return null;
        }
    }
    public static class Log extends Scheme<Log, Library.Log> {

        public static final Log Earth = new Log(Terrene.Earth);
        public static final Log Luna = new Log(Terrene.Luna);
        protected Log(Terrene terrene) {
            super("log",terrene);
        }

        @Override
        protected Director<Log, Library.Log, ?, ?> getNewDirector(String authority) {
            return null;
        }
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
