package dev.inward.matrix;

import dev.inward.matrix.authority.Domain;
import dev.inward.matrix.authority.dns.Terrene;
import dev.inward.matrix.director.library.Memory;
import dev.inward.matrix.director.library.catalog.Catalog;
import dev.inward.matrix.fact.matter.Named;

import java.nio.file.Path;


public class Arena extends Library<Vagor,Arena, Named> {

    public Arena(Vagor scheme, Terrene terrene, Domain domain, Memory<Named>... memories) {
        super(scheme, terrene, domain, memories);
    }

    @Override
    protected Catalog<Vagor, Arena, Named> initCatalog(Arena library, Memory<Named>... memories) {
        return null;
    }

    @Override
    public int compareTo(Arena o) {
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
