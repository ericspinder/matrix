/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.dns.catalogRecord;

import dev.inward.matrix.file.addressed.depot.specification.Specification;
import dev.inward.matrix.file.addressed.depot.standard.Standard;

import java.util.function.Function;

public class HttpCatalogRecordLibrarian extends CatalogRecordLibrarian<HttpCatalogRecordKey,HttpCatalogRecord,HttpCatalogRecordView,HttpCatalogRecordModel,HttpCatalogRecordReference,HttpCatalogRecordLibrarian> {

    public HttpCatalogRecordLibrarian(Standard standard, Specification specification) {
        super(standard, specification);
    }
}
