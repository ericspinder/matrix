package dev.inward.matrix;

import dev.inward.matrix.concept.matter.Indicia;
import dev.inward.matrix.concept.matter.Matter;
import dev.inward.matrix.fact.Addressed;
import dev.inward.matrix.fact.Predictable;
import dev.inward.matrix.fact.datum.Complication;

import java.io.IOException;
import java.net.URI;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Identity<PATH extends Comparable<PATH>,ID extends Comparable<ID>,I extends Identity<PATH,ID,I,A,R>,A extends Addressed<PATH,ID,I,A,R>,R extends Representitive<PATH,ID,I,A,R>> implements Path {

    protected final ID id;
    protected R rider;
    protected final List<Index<PATH,?>> indices = new ArrayList<>();

    @SafeVarargs
    public Identity(ID id, Index<PATH,?>... indices) {
        this.id = id;
        this.indices.addAll(Arrays.asList(indices));
    }

    public void setRider(R rider) {
        if (rider != null) this.rider = rider;
    }

    public ID getId() {
        return id;
    }

    public R getRider() {
        return rider;
    }
    public A getAddressed() {
        if (rider != null) {
            return rider.get();
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public Index<PATH, ?>[] getIndices() {
        return (Index<PATH,?>[]) this.indices.toArray(new Index[indices.size()]);
    }

    @Override
    public FileSystem getFileSystem() {
        return this.getFileSystem(indices.getFirst());
    }
    public FileSystem getFileSystem(Index<PATH,?> index) {
        return index.ledger;
    }

    @Override
    public boolean isAbsolute() {
        return true;
    }

    @Override
    public Path getRoot() {
        return this.getRoot(indices.getFirst());
    }
    public Path getRoot(Index<PATH,?> index) {
        A addressed = this.getAddressed();
        addressed.
    }

    @Override
    public Path getFileName() {
        return this;
    }

    @Override
    public Path getParent() {
        return this.getParent(indices.getFirst());
    }
    public Path getParent(Index<PATH,?> index) {
        return this;
    }

    @Override
    public int getNameCount() {
        return this.getNameCount(indices.getFirst());
    }

    public int getNameCount(Index<PATH,?> index) {
        return 0;
    }

    @Override
    public Path getName(int index) {
        return this.getName(indices.getFirst(),index);
    }

    public Path getName(Index<PATH,?> index, int index_) {
        return null;
    }

    @Override
    public Path subpath(int beginIndex, int endIndex) {
        return this.subpath(indices.getFirst(),beginIndex,endIndex);
    }

    public Path subpath(Index<PATH,?> index, int beginIndex, int endIndex) {
        return null;
    }

    @Override
    public boolean startsWith(Path other) {
        return this.startsWith(indices.getFirst(),other);
    }

    public boolean startsWith(Index<PATH,?> index, Path other) {
        return false;
    }

    @Override
    public boolean endsWith(Path other) {
        return this.endsWith(indices.getFirst(),other);
    }

    public boolean endsWith(Index<PATH,?> index, Path other) {
        return false;
    }

    @Override
    public Path normalize() {
        return this.normalize(indices.getFirst());
    }

    public Path normalize(Index<PATH,?> index) {
        return null;
    }

    @Override
    public Path resolve(Path other) {
        return this.resolve(indices.getFirst(), other);
    }

    public Path resolve(Index<PATH,?> index, Path other) {
        return null;
    }

    @Override
    public Path relativize(Path other) {
        return this.resolve(indices.getFirst(),other);
    }

    public Path relativize(Index<PATH,?> index, Path other) {
        return null;
    }

    @Override
    public URI toUri() {
        return this.toUri(indices.getFirst());
    }

    public URI toUri(Index<PATH,?> index) {
        return null;
    }

    @Override
    public Path toAbsolutePath() {
        return this.toAbsolutePath(indices.getFirst());
    }

    public Path toAbsolutePath(Index<PATH,?> index) {
        return null;
    }

    @Override
    public Path toRealPath(LinkOption... options) throws IOException {
        return this.toRealPath(indices.getFirst(),options);
    }

    public Path toRealPath(Index<PATH,?> index, LinkOption... options) throws IOException {
        return null;
    }

    @Override
    public boolean endsWith(String other) {
        return this.getId().toString().endsWith(other);
    }

    @Override
    public boolean startsWith(String other) {
        return this.startsWith(indices.getFirst(), other);
    }

    public boolean startsWith(Index<PATH,?> index, String other) {
        return index.ledger.getLibrary().getScheme().startsWith(other);
    }

    @SuppressWarnings("unchecked")
    public <C extends Complication<PATH,I,C,M,OCCURRENCE>,M extends Matter<M,OCCURRENCE>,OCCURRENCE extends Comparable<OCCURRENCE>> C register_(Predictable<PATH> watcher, Indicia[] events, Criterion... modifiers) throws IOException {
        return (C) watcher.register(this,events,modifiers);
    }

    @Override
    public WatchKey register(WatchService watcher, WatchEvent.Kind<?>[] events, WatchEvent.Modifier... modifiers) throws IOException {
        try {
            return this.register_((Predictable<PATH>) watcher,(Indicia[]) events,(Criterion[]) modifiers);
        }
        catch (ClassCastException cce) {
            throw new MatrixException(MatrixException.Type.RunProblem,"registration by Identity", Indicia.Focus.Assembly, Indicia.Severity.Critical,cce);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public int compareTo(Path other) {
        if (this.getClass().isInstance(other)) {
            I that = (I) other;
            int isZero = this.id.compareTo(that.id);
            if (isZero == 0) {
                return Arrays.compare(this.indices.toArray(new Index[0]), that.indices.toArray(new Index[0]));
            }
            return isZero;
        }
        return -1;
    }

    public int compareTo(I index, Path other) {
        return 0;
    }
}
