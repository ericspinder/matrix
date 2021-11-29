package dev.inward.matrix.id;

import dev.inward.matrix.Addressable;

import java.net.URL;

public class Id<I extends Id> implements Addressable<I> {

    @Override
    public URL getUrl() {
        return null;
    }

    @Override
    public int compareTo(I o) {
        return 0;
    }
}
