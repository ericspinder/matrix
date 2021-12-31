package com.notionds.dataSupplier.notion.reflection;

import com.notionds.dataSupplier.Container;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.options.Options;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

public class InputStreamDatum<O extends Options<InputStream,W,T>,W extends Datum<InputStream,O,T>, T extends Container<InputStream,O,W>> extends InputStream implements Datum<InputStream,O,T> {

    private final UUID uuid = UUID.randomUUID();
    protected final InputStream delegate;
    protected final T container;

    public InputStreamDatum(T container, InputStream delegate) {
        this.container = container;
        this.delegate = delegate;
    }

    @Override
    public UUID getDatumUuid() {
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
        if (!(that instanceof Datum)) {
            return false;
        }
        if (this.getDatumUuid() == null) {
            if (((Datum)that).getDatumUuid() != null) {
                return false;
            }
        } else if (!this.getDatumUuid().equals(((Datum)that).getDatumUuid())) {
            return false;
        }
        return true;
    }
}
