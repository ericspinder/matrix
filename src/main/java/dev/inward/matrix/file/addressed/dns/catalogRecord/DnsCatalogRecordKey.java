/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.dns.catalogRecord;

import dev.inward.matrix.file.addressed.dns.DnsDirectoryKey;

import java.net.URI;
import java.util.UUID;

public class DnsCatalogRecordKey extends CatalogRecordKey<DnsCatalogRecordKey,DnsCatalogRecord,DnsCatalogRecordReference,DnsCatalogRecordAttributes,DnsCatalogRecordResource,DnsCatalogRecordModel> {
    protected DnsCatalogRecordKey(URI uri, UUID uuid, DnsDirectoryKey directoryKey) {
        super(uri, uuid, directoryKey);
    }

    public static class Builder extends CatalogRecordKey.Builder<DnsCatalogRecordKey,DnsCatalogRecord,DnsCatalogRecordReference,DnsCatalogRecordAttributes,DnsCatalogRecordResource,DnsCatalogRecordModel> {


        @Override
        protected DnsCatalogRecordKey newFileKey() {
            return new DnsCatalogRecordKey(this.uri,this.id,this.directoryKey);
        }
    }
}
