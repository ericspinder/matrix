package dev.inward.matrix.director.library;

import dev.inward.matrix.Clerk;
import dev.inward.matrix.Librarian;
import dev.inward.matrix.Library;
import dev.inward.matrix.Scheme;
import dev.inward.matrix.route.Road;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Director<S extends Scheme<S,L>,L extends Library<S,L>,D extends Director<S,L,D,R>,R extends Road<S,L,D,R>> extends URLStreamHandler {

    protected final S scheme;
    protected final R road;
    protected final Map<Library<?,?>,Librarian<?,?,?,?>> librarians;

    public Director(S scheme,R road) {
        this(scheme,road,new ConcurrentHashMap<>());
    }
    public Director(S scheme, R road, Map<Library<?,?>,Librarian<?,?,?,?>> librarians) {
        this.scheme = scheme;
        this.road = road;
        this.librarians = librarians;
    }

    public S getScheme() {
        return scheme;
    }

    public R getRoad() {
        return road;
    }


    public Map<Library<?, ?>, Librarian<?, ?, ?, ?>> getLibrarians() {
        return librarians;
    }

    @Override
    protected URLConnection openConnection(URL url) throws IOException {
        return this.open(url);
    }

    protected <C extends Clerk<S,L,?,C>> C open(URL url) throws IOException {
        return null;
    }



}
