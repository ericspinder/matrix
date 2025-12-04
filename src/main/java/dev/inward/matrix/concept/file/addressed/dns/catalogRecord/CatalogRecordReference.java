/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.concept.file.addressed.dns.catalogRecord;

import dev.inward.matrix.concept.file.addressed.dns.RRReference;

public class CatalogRecordReference extends RRReference<CatalogRecord, CatalogRecordKey, CatalogRecordView, CatalogRecordModel, CatalogRecordReference, CatalogRecordLibrarian> {

    public CatalogRecordReference(CatalogRecord referent, CatalogRecordLibrarian librarian) {
        super(referent, librarian);
    }
}
