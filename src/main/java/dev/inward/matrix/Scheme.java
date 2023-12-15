package dev.inward.matrix;

import dev.inward.matrix.authority.dns.Terrene;
import dev.inward.matrix.director.library.Director;
import dev.inward.matrix.director.library.Memory;
import dev.inward.matrix.director.library.catalog.Catalog;
import dev.inward.matrix.fact.Fact;
import dev.inward.matrix.fact.authoritative.notion.Notion;
import dev.inward.matrix.fact.matter.Indicia;

import java.io.IOException;
import java.net.*;
import java.net.spi.URLStreamHandlerProvider;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.spi.FileSystemProvider;
import java.util.Map;
import java.util.Set;
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
    protected final String scheme;
    protected final Map<String,Director<S,L,?,?>> directors = new ConcurrentHashMap<>();
    protected volatile transient Director<S,L,?,?> defaultNewLibrary;
    protected Scheme(String scheme) {
        this.scheme = scheme;
    }

    public static class DNS extends Scheme<DNS,Library.DNS> {
        public final static DNS Instance = new DNS();
        private DNS() {
            super("dns");
        }
    }
    public static class HTML extends Scheme<HTML,Library.HTML> {
        public final static HTML Instance = new HTML();
        private HTML() {
            super("html");
        }
    }


    @Override
    protected Clerk<S,L,?,?> openConnection(URL u) throws IOException {
        if(!u.getProtocol().equalsIgnoreCase(this.scheme))
            throw new MatrixException(MatrixException.Type.ClassCastException,"clerk", Indicia.Focus.Assembly, Indicia.Severity.Critical, new Exception("stacktrace..."));
        String authority = u.getAuthority();
        Director<S,L,?,?> director = this.directors.get(authority);
        if (director == null) {
            // is it a Server or Client connection?
            // get DNS info
            // init library
            // init user(anonymous and userInfo if it exists)/catalogs/librarians
            // init notions/facts/etc
        }
        return null;
    }

    @Override
    public int compareTo(S that) {
        return this.scheme.compareTo(that.scheme);
    }
}
