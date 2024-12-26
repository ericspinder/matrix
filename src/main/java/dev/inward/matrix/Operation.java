package dev.inward.matrix;

import java.net.URL;

public abstract class Operation<PATH extends Comparable<PATH>,,O extends Operation<PATH,F,O,D>,D extends Dogma> implements Comparable<O> {

    protected final URL url;
    protected abstract D[] dogma();

    public Operation(URL url) {
        this.url = url;
    }

    public URL getUrl() {
        return url;
    }

    public
}
