/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.dns.catalogRecord;

import dev.inward.matrix.file.addressed.depot.specification.Specification;
import dev.inward.matrix.file.addressed.depot.standard.Standard;

public class InfoCatalogRecordLibrarian extends CatalogRecordLibrarian<InfoCatalogRecordKey,InfoCatalogRecord,InfoCatalogRecordView,InfoCatalogRecordModel,InfoCatalogRecordReference,InfoCatalogRecordLibrarian> {

    public InfoCatalogRecordLibrarian(Standard standard, Specification specification) {
        super(standard, specification);
    }
}