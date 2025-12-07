/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.concept.fact.addressed.dns.catalogRecord;

import dev.inward.matrix.concept.fact.addressed.dns.RRView;

public class CatalogRecordView extends RRView<CatalogRecord, CatalogRecordKey, CatalogRecordView, CatalogRecordModel, CatalogRecordReference, CatalogRecordLibrarian> {


    public CatalogRecordView(String name, CatalogRecord catalogRecord) {
        super(name, catalogRecord);
    }
}
