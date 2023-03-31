package dev.inward.matrix.authority;

import dev.inward.matrix.engine.Zone;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.AsynchronousChannel;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.util.Objects;

public abstract class Domain<Z extends Zone<Z>,CHANNEL extends AsynchronousChannel,A extends Authority<Z,CHANNEL,A>,D extends Domain<Z,CHANNEL,A,D>> implements Comparable<D> {

    protected final Z zone;
    protected final A parent;
    protected final String name;
    protected final URL url;
    protected final FileStore fileStore;

    public Domain(@Nonnull Z zone,@Nonnull A parent, @Nullable String name) {
        this.zone = zone;
        this.parent = parent;
        this.name = name;
        url = this.zone.createUrl(this);
    }

    public FILESYSTEM getFileSystem() {
        return this.parent.getFileSystem();
    }

    @Override
    @SuppressWarnings("all")
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Domain)) return false;
        D that = (D) o;
        return Objects.equals(this.parent,that.parent) && this.name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parent, name);
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(@Nonnull  D that) {
        if (this.parent == null && that.parent == null) {
            return this.name.compareTo(that.name);
        }
        if (this.parent == null) {
            return -1;
        }
        if (that.parent == null) {
            return 1;
        }
        int isZero = this.parent.compareTo(that.parent);
        if (isZero == 0) {
            return this.name.compareTo(that.name);
        }
        return isZero;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (parent != null) {
             stringBuilder.append(this.parent);
        }
        stringBuilder.append(this.name);
        return stringBuilder.toString();
    }
}
