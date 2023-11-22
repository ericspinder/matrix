package dev.inward.matrix.director;

import dev.inward.matrix.HttpLibrary;
import dev.inward.matrix.Scheme;
import dev.inward.matrix.director.library.Memory;

public class HttpScheme extends Scheme<HttpScheme, HttpLibrary,String> {

    public HttpScheme() {
        super("http");
    }

    @Override
    public long initTotalSpace(Memory<String> memory) {
        return 0;
    }
}
