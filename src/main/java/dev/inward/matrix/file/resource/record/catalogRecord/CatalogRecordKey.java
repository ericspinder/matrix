/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.resource.record.catalogRecord;

import dev.inward.matrix.file.resource.record.DnsDirectoryKey;
import dev.inward.matrix.file.resource.record.RRKey;

import java.net.URI;
import java.util.UUID;

public class CatalogRecordKey extends RRKey<CatalogRecord,CatalogRecordKey,CatalogRecordView,CatalogRecordModel,CatalogRecordReference,CatalogRecordLibrarian> {

    protected final String protocolString;
    protected CatalogRecordKey(URI uri, UUID uuid, DnsDirectoryKey directoryKey, String protocolString) {
        super(uri, uuid, directoryKey,false);
        this.protocolString = protocolString;
    }

    public static class Builder extends RRKey.Builder<CatalogRecord,CatalogRecordKey,CatalogRecordView,CatalogRecordModel,CatalogRecordReference,CatalogRecordLibrarian> {

        public Builder() {
            this.randomUUID = false;
        }
        @Override
        public Builder setRandomUUID(boolean isRandomUUID) {
            if (isRandomUUID) {
                throw new RuntimeException("CatalogRecordKeys never have a randomUUID");
            }
            return this;
        }
    }
}
