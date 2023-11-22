package dev.inward.matrix.engine;

import dev.inward.matrix.Scheme;
import dev.inward.matrix.Library;
import dev.inward.matrix.fact.authoritative.notion.Notion;

import javax.annotation.Nonnull;
import java.security.CodeSource;

public class Variant<S extends Scheme<S,L>,L extends Library<S,L>> extends CodeSource {

    protected final L library;

    public Variant(@Nonnull L library) {
        super(library.getDomain().url, library.getCodeSigners());
        this.library = library;
    }

    public L getLibrary() {
        return library;
    }
}