/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.dns.catalogRecord;

import dev.inward.matrix.Aspect;

public class DepotCatalogRecordModel extends CatalogRecordModel<DepotCatalogRecordKey, DepotCatalogRecord, DepotCatalogRecordReference, DepotCatalogRecordAttributes, DepotCatalogRecordResource, DepotCatalogRecordModel> {
    public DepotCatalogRecordModel(Aspect[] labeledAspects, long warnOnTotal, long hardLimit) {
        super(labeledAspects, warnOnTotal, hardLimit);
    }
}
