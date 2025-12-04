/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package dev.inward.matrix.concept.file.addressed.depot.source;

import dev.inward.matrix.concept.file.addressed.depot.Depot;

public class Source extends Depot<Source,SourceKey,SourceView,SourceModel, SourceReference, SourceLibrarian> {
    public Source(SourceKey identity) {
        super(identity);
    }

//    protected final Map<Edition, Registrar> editionRegistrarMap;


}
