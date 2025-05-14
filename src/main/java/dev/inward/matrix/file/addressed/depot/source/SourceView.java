/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.depot.source;

import dev.inward.matrix.file.addressed.depot.DepotView;

public class SourceView extends DepotView<Source,SourceKey,SourceView,SourceModel,SourceReference,SourceLibrarian> {
    public SourceView(String name, Source file) {
        super(name, file);
    }
}
