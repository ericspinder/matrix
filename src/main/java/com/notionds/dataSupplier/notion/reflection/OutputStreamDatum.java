package com.notionds.dataSupplier.notion.reflection;

import com.notionds.dataSupplier.Container;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.operational.Operational;

import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

public class OutputStreamDatum<O extends Operational<OutputStream,W,T>, W extends Datum<OutputStream,O,T>,T extends Container<OutputStream,O,W>> extends OutputStream implements Datum<OutputStream,O,T> {

    private UUID uuid = UUID.randomUUID();
    protected final OutputStream delegate;
    protected final T container;

    public OutputStreamDatum(T container, OutputStream delegate) {
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
    public OutputStream getDelegate() {
        return this.delegate;
    }

    @Override
    public void close() throws IOException {
        this.flush();
        this.container.closeDelegate();
    }

    @Override
    public void write(int b) throws IOException {
        try {
            delegate.write(b);
        }
        catch(IOException ioe) {
            container.handleException(ioe, this);
            throw ioe;
        }
    }

    @Override
    public void flush() throws IOException {
        try {
            delegate.flush();
        }
        catch(IOException ioe) {
            container.handleException(ioe, this);
            throw ioe;
        }
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
