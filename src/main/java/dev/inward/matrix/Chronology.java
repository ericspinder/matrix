package dev.inward.matrix;

import dev.inward.matrix.authority.Domain;
import dev.inward.matrix.authority.dns.Terrene;
import dev.inward.matrix.director.library.Memory;
import dev.inward.matrix.director.library.catalog.Catalog;

import java.nio.file.Path;

public class Chronology extends Library<Log, Chronology, GroupByDate> {

    public Chronology(Log scheme, Terrene terrene, Domain domain, Memory<GroupByDate>... memories) {
        super(scheme, terrene, domain, memories);
    }

    @Override
    protected Catalog<Log, Chronology, GroupByDate> initCatalog(Library<Log, Chronology, GroupByDate> library, Memory<GroupByDate>... memories) {
        return null;
    }

    public Iterable<Path> getRootDirectories() {
        return null;
    }

    @Override
    public Path getPath(String first, String... more) {
        return null;
    }

    @Override
    public int compareTo(Chronology o) {
        return 0;
    }
}
