package dev.inward.matrix.director.library;

import dev.inward.matrix.Librarian;
import dev.inward.matrix.Library;
import dev.inward.matrix.Scheme;
import dev.inward.matrix.route.Dispatch;
import dev.inward.matrix.route.Driver;
import dev.inward.matrix.route.Road;

import java.io.Closeable;
import java.nio.channels.AsynchronousChannel;
import java.nio.channels.AsynchronousFileChannel;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public abstract class Director<D extends Dispatch<D,R>,R extends Road<D,R>> {

    protected final Scheme scheme;
    protected final R road;
    protected final Map<Library,Librarian<?,?,?,?,?,?>> librarians;

    public Director(Scheme scheme,R road) {
        this(scheme,road,new ConcurrentHashMap<>());
    }
    public Director(Scheme scheme, R road, Map<Library,Librarian<?,?,?,?,?,?>> librarians) {
        this.scheme = scheme;
        this.road = road;
        this.librarians = librarians;
    }

    public Scheme getScheme() {
        return scheme;
    }

    public R getRoad() {
        return road;
    }


    public Map<Library, Librarian<?,?,?,?,?,?>> getLibrarians() {
        return librarians;
    }

}
