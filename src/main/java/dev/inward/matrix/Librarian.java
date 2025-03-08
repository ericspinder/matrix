/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix;

import dev.inward.matrix.route.Dispatch;
import dev.inward.matrix.route.Road;

public abstract class Librarian<S extends Scheme<S,L>,L extends Library<S,L>,K extends MatrixKey<S,L,K>,D extends Dispatch<D,R>,R extends Road<D,R>> {

    public final L library;
    public final R road;

    protected Librarian(L library, R road) {
        this.library = library;
        this.road = road;
    }

    public L getLibrary() {
        return library;
    }

    public R getRoad() {
        return road;
    }
    public static class Curator<S extends Scheme<S,L>,L extends Library<S,L>,K extends LibraryKey<S,L>> extends Librarian<S,L,K,Dispatch.Network,Road.Network> {

        protected Curator(L library, Road.Network road) {
            super(library, road);
        }
    }
    public static class Conservator<S extends Scheme<S,L>,L extends Library<S,L>,K extends CatalogKey<S,L>,D extends Dispatch<D,R>,R extends Road<D,R>> {

    }
}
