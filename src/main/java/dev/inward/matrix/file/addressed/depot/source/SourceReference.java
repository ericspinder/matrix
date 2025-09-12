/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.depot.source;

import dev.inward.matrix.file.addressed.depot.DepotReference;

public class SourceReference extends DepotReference<Source,SourceKey,SourceView,SourceModel, SourceReference, SourceLibrarian> {
    public SourceReference(Source addressed, SourceLibrarian resource) {
        super(addressed, resource);
    }
}
