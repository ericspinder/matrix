package com.notionds.dataSupplier.delegation.reflection;

import com.notionds.dataSupplier.Container;
import com.notionds.dataSupplier.delegation.Wrapper;
import com.notionds.dataSupplier.operational.Operational;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

public class InputStreamWrapper<O extends Operational<InputStream,W,T>,W extends Wrapper<InputStream,O,T>, T extends Container<InputStream,O,W>> extends InputStream implements Wrapper<InputStream,O,T> {

    private final UUID uuid = UUID.randomUUID();
    protected final InputStream delegate;
    protected final T container;

    public InputStreamWrapper(T container, InputStream delegate) {
        this.container = container;
        this.delegate = delegate;
    }

    @Override
    public UUID getArtifactId() {
        return this.uuid;
    }
    @Override
    public T getContainer() {
        return this.container;
    }

    @Override
    public InputStream getDelegate() {
        return this.delegate;
    }

    @Override
    public int read() throws IOException {
        try {
            return delegate.read();
        }
        catch (IOException ioe) {
            container.handleException(ioe, this);
            throw ioe;
        }
    }

    @Override
    public void close() throws IOException {
        this.container.closeDelegate();
    }
    @Override
    public final boolean equals(final Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (!(that instanceof Wrapper)) {
            return false;
        }
        if (this.getArtifactId() == null) {
            if (((Wrapper)that).getArtifactId() != null) {
                return false;
            }
        } else if (!this.getArtifactId().equals(((Wrapper)that).getArtifactId())) {
            return false;
        }
        return true;
    }
}
