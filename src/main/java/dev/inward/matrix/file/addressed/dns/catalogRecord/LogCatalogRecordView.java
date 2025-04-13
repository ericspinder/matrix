/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.dns.catalogRecord;

public class LogCatalogRecordView extends CatalogRecordView<LogCatalogRecordLibrarian,LogCatalogRecordKey,LogCatalogRecord,LogCatalogRecordView,LogCatalogRecordModel,LogCatalogRecordReference, LogCatalogRecordSteward> {
    public LogCatalogRecordView(LogCatalogRecord logCatalogRecord, LogCatalogRecordModel logCatalogRecordModel) {
        super("LogCatalogRecordView", logCatalogRecord, logCatalogRecordModel);
    }
}
