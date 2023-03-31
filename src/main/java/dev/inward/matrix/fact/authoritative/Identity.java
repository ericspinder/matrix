package dev.inward.matrix.fact.authoritative;

import dev.inward.matrix.Meta_I;
import dev.inward.matrix.engine.Variant;
import dev.inward.matrix.fact.Context;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.*;
import java.time.Instant;
import java.util.*;
import java.util.function.Consumer;

public abstract class Identity<I extends Identity<I,ID,X>,ID extends Comparable<ID>,X extends Context<X>> implements Path, Comparable<I> {

    public static final char Aforementioned = '\u0000';

    protected final I parent;
    protected final char persona;
    protected final ID id;

    @Override
    public FileSystem getFileSystem() {
        return ((Variant)getContext().getCodeSource()).getDomain().getFileSystem();
    }

    @Override
    public boolean isAbsolute() {
        return false;
    }

    @Override
    public Identity<?,?,X> getRoot() {
        return null;
    }

    @Override
    @SuppressWarnings("all")
    public I getFileName() {
        return (I) this;
    }

    @Override
    public Identity<?,?,X> getParent() {
        return this.parent;
    }

    @Override
    public int getNameCount() {
        if (this.parent == null) {
            return 1;
        }
        return this.parent.doNameCount(1);
    }
    protected int doNameCount(int previous) {
        ++previous;
        if (this.parent == null) {
            return previous;
        }
        return this.doNameCount(previous);
    }

    @Override
    public I getName(int index) {
        if(index == 0) {
            return (I) this;
        }
        return (Variant)((this.getContext().getCodeSource()).)
    }

    @Override
    public Identity subpath(int beginIndex, int endIndex) {
        return null;
    }

    @Override
    public boolean startsWith(Path other) {
        return false;
    }

    @Override
    public boolean endsWith(Path other) {
        return false;
    }

    @Override
    public Identity normalize() {
        return null;
    }

    @Override
    public Identity resolve(Path other) {
        return null;
    }

    @Override
    public Identity relativize(Path other) {
        return null;
    }

    @Override
    public URI toUri() {
        return null;
    }

    @Override
    public Identity toAbsolutePath() {
        return null;
    }

    @Override
    public Path toRealPath(LinkOption... options) throws IOException {
        return null;
    }

    @Override
    public WatchKey register(WatchService watcher, WatchEvent.Kind<?>[] events, WatchEvent.Modifier... modifiers) throws IOException {
        return null;
    }

    @Override
    public boolean startsWith(String other) {
        return Path.super.startsWith(other);
    }

    @Override
    public boolean endsWith(String other) {
        return Path.super.endsWith(other);
    }

    @Override
    public Identity resolve(String other) {
        return null;
    }

    @Override
    public Identity resolveSibling(Path other) {
        return null;
    }

    @Override
    public I resolveSibling(String other) {
        return (I) getParent().resolve(other);
    }

    @Override
    public File toFile() {
        return Path.super.toFile();
    }

    @Override
    public WatchKey register(WatchService watcher, WatchEvent.Kind<?>... events) throws IOException {
        return Path.super.register(watcher, events);
    }

    @Override
    public Iterator<Path> iterator() {
        return Path.super.iterator();
    }

    @Override
    public void forEach(Consumer<? super Path> action) {
        Path.super.forEach(action);
    }

    @Override
    public Spliterator<Path> spliterator() {
        return Path.super.spliterator();
    }

    public static class Titled<R extends Reachable<R>,T extends Identity.Titled<R,T>> extends Identity<T, R,Context.Ethereal> {

        public boolean open;
        publi
        public Titled(T parent, char persona, R reachable) {
            super(parent, persona, reachable);
        }

        @Override
        public int compareTo(Path other) {
            return 0;
        }
    }
    public static class Versioned<VERSION extends Comparable<VERSION>,V extends Identity.Versioned<VERSION,V,ID,EXPIRE,G>,ID extends Comparable<ID>,EXPIRE extends Comparable<EXPIRE>,G extends Context.Governance<EXPIRE,G>> extends Identity<V,ID,G> {

        protected final VERSION version;

        public Versioned(V parent,char persona, ID id, VERSION version) {
            super(parent,persona,id);
            this.version = version;
        }
        public VERSION getVersion() {
            return version;
        }

        @Override
        public int compareTo(Path that) {
            return 0;
        }
    }

    public Identity(I parent,char persona, ID id) {
        this.parent = parent;
        this.persona = persona;
        this.id = id;
    }

    @SuppressWarnings("unchecked")
    public final X getContext() {
        return (X) this.getClass().getProtectionDomain();
    }

    public final ID getId() {
        return id;
    }

    public final char getPersona() {
        return persona;
    }

    @Override
    @SuppressWarnings("unchecked")
    public int compareTo(I that) {
        int isZero = ((X)this.getClass().getProtectionDomain()).compareTo((X)that.getClass().getProtectionDomain());
        if (isZero == 0) {
            isZero = this.id.compareTo(that.id);
        }
        return isZero;
    }

    public static class Web extends Identity<Web,String,Context.Path> {

        public enum Relativity implements Meta_I {
            Parent("parent","The parent Web object, or 'up' the directory structure"),
            Previous("previous","The previous Web object, for it 'this' is it's next"),
            Next("next","The next Web object"),
            Instructions("instructions","Instructions for this Web object"),
            Index("index","A separate index for this Web object"),
            Citation("citation", "An Web object cited by this Web object in a material way"),
            Credit("credit","A Web object which shows for whom to give praise or general contact"),
            Impute("impute", "Impute instructs how to complain about this Web object");

            protected final String label;
            protected final String description;

            Relativity(String label,String description) {
                this.label = label;
                this.description = description;
            }
            @Override
            public String getLabel() {
                return this.label;
            }

            @Override
            public String getDescription() {
                return this.description;
            }

            @Override
            public String getClassName() {
                return Meta_I.super.getClassName();
            }
        }
        protected final Map<Web,Relativity> relativityMap;
        public Web(Web web,char persona, String name,Map<Web,Relativity> relativityMap) {
            super(web,persona,name);
            this.relativityMap = relativityMap;
        }

        @Override
        public int compareTo(Path other) {
            return 0;
        }
    }

    public static class Dated extends Identity<Dated, Instant,Context.Ranged> {
        public Dated(Dated parent, char persona, Instant instant) {
            super(parent,persona,instant);
        }

        @Override
        @SuppressWarnings("all")
        public int compareTo(Path other) {
            if (this == other) return 0;
            if (!(other instanceof Identity)) return -1;
            Identity<Dated,Instant, Context.Ranged> that = (Identity<Dated,Instant, Context.Ranged>)other;
            int isZero = this.persona - that.persona;
            if (isZero == 0) {
                return this.id.compareTo(that.id);
            }
            return isZero;
        }
    }
    public static class SuperEgo extends Identity<SuperEgo,String,Context.Path> {

        public SuperEgo(char persona, String name) {
            super(null,persona, name);
        }
    }
    public static final class Ego extends Identity<Ego,UUID, Context.Ethereal> {

        public Ego(Ego parent, UUID uuid) {
            super(parent,parent.persona,uuid);
        }

        @Override
        @SuppressWarnings("all")
        public int compareTo(Path o) {
            if(this == o) return 0;
            if(!(o instanceof Identity)) return -1;
            Identity<Ego,UUID, Context.Ethereal> that = (Identity<Ego,UUID, Context.Ethereal>)o;
            int isZero =  this.getContext().compareTo(that.getContext());
            if (isZero == 0) {
                    return this.id.compareTo(that.id);
            }
            return isZero;
        }


    }
    public static final Ego Ghost = new Ego();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Identity)) return false;
        Identity<?, ?, ?> that = (Identity<?, ?, ?>) o;
        return persona == that.persona && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(persona, id);
    }
}
