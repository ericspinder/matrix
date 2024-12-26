package dev.inward.matrix;

import dev.inward.matrix.director.HttpScheme;
import dev.inward.matrix.memory.Memory;

import java.nio.file.Path;

public class HttpLibrary extends Library<HttpScheme,HttpLibrary,String> {

    public HttpLibrary(HttpScheme scheme, Terrene terrene, Domain domain, Memory<String>... memories) {
        super(scheme, terrene, domain, memories);
    }

    @Override
    protected Ledger<HttpScheme, HttpLibrary, String> initCatalog(HttpLibrary library, Memory<String>... memories) {
        return null;
    }

    @Override
    public int compareTo(HttpLibrary o) {
        return 0;
    }

    @Override
    public Iterable<Path> getRootDirectories() {
        return null;
    }

    @Override
    public Path getPath(String first, String... more) {
        return null;
    }
}
