/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.dns.catalogRecord;

import dev.inward.matrix.file.addressed.dns.DnsDirectoryKey;
import dev.inward.matrix.file.addressed.dns.ResourceRecordType;

public class HttpCatalogRecordParser extends CatalogRecordParser<HttpCatalogRecordKey,HttpCatalogRecord,HttpCatalogRecordView,HttpCatalogRecordModel,HttpCatalogRecordReference,HttpCatalogRecordLibrarian> {
    public HttpCatalogRecordParser(DnsDirectoryKey directoryKey) {
        super(directoryKey);
    }

    @Override
    protected ResourceRecordType expectedDnsPathRecordType() {
        return ResourceRecordType.HttpCatalogRecord;
    }

    @Override
    protected HttpCatalogRecordKey.Builder newRRKeyBuilder() {
        return new HttpCatalogRecordKey.Builder();
    }
}
