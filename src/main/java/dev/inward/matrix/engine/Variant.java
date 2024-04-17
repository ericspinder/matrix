package dev.inward.matrix.engine;

import dev.inward.matrix.Scheme;
import dev.inward.matrix.Library;
import dev.inward.matrix.fact.authoritative.notion.Notion;

import javax.annotation.Nonnull;
import java.net.URL;
import java.security.CodeSource;

public class Variant<S extends Scheme<S,L>,L extends Library<S,L>> extends CodeSource {

    protected final L library;
    protected final Zone zone;

    protected Variant(@Nonnull L library,Zone zone) {
        super(library.getDomain().getUrl(), library.getCodeSigners(zone));
        this.library = library;
        this.zone = zone;
    }

    public L getLibrary() {
        return library;
    }

    public Zone getZone() {
        return zone;
    }

    @Override
    public boolean implies(CodeSource codesource) {
        return super.implies(codesource);
    }
}