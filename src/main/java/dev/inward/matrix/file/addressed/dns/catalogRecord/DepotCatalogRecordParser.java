/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.dns.catalogRecord;

import dev.inward.matrix.file.addressed.dns.DnsDirectoryKey;
import dev.inward.matrix.file.addressed.dns.RRKey;
import dev.inward.matrix.file.addressed.dns.ResourceRecordType;

public class DepotCatalogRecordParser extends CatalogRecordParser<DepotCatalogRecordLibrarian,DepotCatalogRecordKey,DepotCatalogRecord,DepotCatalogRecordView,DepotCatalogRecordModel,DepotCatalogRecordReference, DepotCatalogRecordSteward> {
    public DepotCatalogRecordParser(DnsDirectoryKey directoryKey) {
        super(directoryKey);
    }

    @Override
    protected ResourceRecordType expectedDnsPathRecordType() {
        return ResourceRecordType.DepotCatalogRecord;
    }

    @Override
    protected RRKey.Builder<DepotCatalogRecordLibrarian, DepotCatalogRecordKey, DepotCatalogRecord, DepotCatalogRecordView, DepotCatalogRecordModel, DepotCatalogRecordReference, DepotCatalogRecordSteward> newRRKeyBuilder() {
        return null;
    }


}



