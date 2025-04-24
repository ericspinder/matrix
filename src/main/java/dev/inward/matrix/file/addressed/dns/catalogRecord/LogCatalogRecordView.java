/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.dns.catalogRecord;

public class LogCatalogRecordView extends CatalogRecordView<LogCatalogRecordKey,LogCatalogRecord,LogCatalogRecordView,LogCatalogRecordModel,LogCatalogRecordReference,LogCatalogRecordLibrarian> {
    public LogCatalogRecordView(String name, LogCatalogRecord file, LogCatalogRecordReference fileReference) {
        super(name, file, fileReference);
    }
}
