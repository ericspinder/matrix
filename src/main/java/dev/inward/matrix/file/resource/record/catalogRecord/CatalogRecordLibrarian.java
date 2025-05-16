/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.resource.record.catalogRecord;

import dev.inward.matrix.file.addressed.depot.specification.Specification;
import dev.inward.matrix.file.addressed.depot.standard.Standard;
import dev.inward.matrix.file.resource.record.RRLibrarian;

public class CatalogRecordLibrarian extends RRLibrarian<CatalogRecord,CatalogRecordKey,CatalogRecordView,CatalogRecordModel,CatalogRecordReference,CatalogRecordLibrarian> {
    public CatalogRecordLibrarian(Standard standard) {
        super(standard);
    }
}
