package dev.inward.matrix.engine;

import dev.inward.matrix.Scheme;
import dev.inward.matrix.Library;
import dev.inward.matrix.fact.authoritative.notion.Notion;

import javax.annotation.Nonnull;
import java.net.URL;
import java.security.CodeSource;

public class Variant<S extends Scheme<S,L>,L extends Library<S,L>> extends CodeSource {

    protected final L library;

    protected Variant(@Nonnull L library) {
        super(library.getDomain().getUrl(), library.getCodeSigners());
        this.library = library;
    }

    public L getLibrary() {
        return library;
    }
}