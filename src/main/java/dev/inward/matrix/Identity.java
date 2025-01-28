package dev.inward.matrix;

import dev.inward.matrix.predictable.Predictable;

import java.io.IOException;
import java.net.URI;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Identity<PATH extends Comparable<PATH>,ID extends Comparable<ID>,I extends Identity<PATH,ID,I,A,R,F>,A extends Addressed<PATH,ID,I,A,R,F>,R extends Representative<PATH,ID,I,A,R,F>,F extends Addressed.FileAttributes<PATH,ID,I,A,R,F>> extends FileKey<PATH, I, A, F> {

    protected final ID id;
    protected transient R rider;

    public Identity(Index<PATH> index, Query query, ID id) {
        super(index,query);
        this.id = id;
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

    @Override
    public Library<?,?,PATH> getLibrary() {
        return this.getFileSystem(this.index).library;
    }

    @Override
    public Range<PATH> getRange() {
        return this.getRange(this.index);
    }

    @Override
    public WatchKey register(WatchService watcher, WatchEvent.Kind<?>[] events, WatchEvent.Modifier... modifiers) throws IOException {
        return null;
    }

    public Range<PATH> getRange(Index<PATH,?> index) {
        return index.ledger.getRange();
    }

    @Override
    public FileSystem getFileSystem() {
        return this.getFileSystem(this.index);
    }
    public Ledger<PATH> getFileSystem(Index<PATH,?> index) {
        return index.ledger;
    }

    @Override
    public boolean isAbsolute() {
        return true;
    }

    @Override
    public Path getRoot() {
        Path path = (Path) rider.attributes.properties.get("root");
        if (path == null) {
            path = findRoot();
            if (path != null) {
                rider.attributes.properties.put("root",path);
            }
        }
        return path;
    }
    protected Path findRoot() {
        return null;
    }

    @Override
    public Path getFileName() {
        return this;
    }

    @Override
    public Path getParent() {
        return this.getParent(this.index);
    }
    public Path getParent(Index<PATH,?> index) {
        return this;
    }

    @Override
    public int getNameCount() {
        return this.getNameCount(this.index);
    }

    public int getNameCount(Index<PATH,?> index) {
        return 0;
    }

    @Override
    public Path getName(int index) {
        return this.getName(this.index,index);
    }

    public Path getName(Index<PATH,?> index, int index_) {
        return null;
    }

    @Override
    public Path subpath(int beginIndex, int endIndex) {
        return this.subpath(this.index,beginIndex,endIndex);
    }

    public Path subpath(Index<PATH,?> index, int beginIndex, int endIndex) {
        return null;
    }

    @Override
    public boolean startsWith(Path other) {
        return this.startsWith(this.index,other);
    }

    public boolean startsWith(Index<PATH,?> index, Path other) {
        return false;
    }

    @Override
    public boolean endsWith(Path other) {
        return this.endsWith(this.index,other);
    }

    public boolean endsWith(Index<PATH,?> index, Path other) {
        return false;
    }

    @Override
    public Path normalize() {
        return this.normalize(this.index);
    }

    public Path normalize(Index<PATH,?> index) {
        return null;
    }

    @Override
    public Path resolve(Path other) {
        return this.resolve(this.index, other);
    }

    public Path resolve(Index<PATH,?> index, Path other) {
        return null;
    }

    @Override
    public Path relativize(Path other) {
        return this.resolve(this.index,other);
    }

    public Path relativize(Index<PATH,?> index, Path other) {
        return null;
    }

    @Override
    public URI toUri() {
        URI uri = new URI(index.getLedger().getLibrary().getScheme(),index.getLedger().getLibrary().domain,index.getLedger().getLibrary().getPort());
    }


    @Override
    public Path toAbsolutePath() {
        return this;
    }

    @Override
    public Path toRealPath(LinkOption... options) throws IOException {
        return null;
    }



    @Override
    public boolean endsWith(String other) {
        return this.getId().toString().endsWith(other);
    }

    @Override
    public boolean startsWith(String other) {
        return this.startsWith(this.index, other);
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
