package com.notionds.dataSupplier.notion.reflection;

import com.notionds.dataSupplier.Container;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.options.Options;

import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;
import java.util.UUID;

public class ReaderDatum<O extends Options<Reader,W,T>, W extends Datum<Reader,O,T>,T extends Container<Reader,O,W>> extends Reader implements Datum<Reader,O,T> {

    private final UUID uuid = UUID.randomUUID();
    private final T container;
    private final Reader delegate;

    public ReaderDatum(T container, Reader delegate) {
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
    public Reader getDelegate() {
        return this.delegate;
    }

    @Override
    public int read(CharBuffer target) throws IOException {
        try {
            return delegate.read(target);
        }
        catch (IOException ioe) {
            container.handleException(ioe, this);
            throw ioe;
        }
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
    public int read(char[] cbuf) throws IOException {
        try {
            return delegate.read(cbuf);
        }
        catch (IOException ioe) {
            container.handleException(ioe, this);
            throw ioe;
        }
    }

    @Override
    public boolean markSupported() {
        return delegate.markSupported();
    }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        try {
            return delegate.read(cbuf, off, len);
        }
        catch (IOException ioe) {
            container.handleException(ioe, this);
            throw ioe;
        }
    }

    @Override
    public long skip(long n) throws IOException {
        try {
            return delegate.skip(n);
        }
        catch (IOException ioe) {
            container.handleException(ioe, this);
            throw ioe;
        }
    }

    @Override
    public boolean ready() throws IOException {
        try {
            return delegate.ready();
        }
        catch (IOException ioe) {
            container.handleException(ioe, this);
            throw ioe;
        }
    }

    @Override
    public void mark(int readAheadLimit) throws IOException {
        try {
            delegate.mark(readAheadLimit);
        }
        catch (IOException ioe) {
            container.handleException(ioe, this);
            throw ioe;
        }
    }

    @Override
    public void reset() throws IOException {
        try {
            delegate.reset();
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
