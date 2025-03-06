/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.dns.catalogRecord;

import dev.inward.matrix.Range;
import dev.inward.matrix.file.addressed.AddressedKey;
import dev.inward.matrix.file.addressed.dns.DnsDirectoryKey;
import dev.inward.matrix.file.addressed.dns.RRKey;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;

public class CatalogRecordKey<K extends CatalogRecordKey<K,F,R,A,RESOURCE,M>,F extends CatalogRecord<K,F,R,A,RESOURCE,M>,R extends CatalogRecordReference<K,F,R,A,RESOURCE,M>,A extends CatalogRecordAttributes<K,F,R,A,RESOURCE,M>,RESOURCE extends CatalogRecordResource<K,F,R,A,RESOURCE,M>,M extends CatalogRecordModel<K,F,R,A,RESOURCE,M>> extends RRKey<K, F, R, A, RESOURCE, M> {
    protected CatalogRecordKey(URI uri, UUID uuid, DnsDirectoryKey directoryKey) {
        super(uri, uuid, directoryKey,false);
    }

    public static abstract class Builder<K extends CatalogRecordKey<K,F,R,A,RESOURCE,M>,F extends CatalogRecord<K,F,R,A,RESOURCE,M>,R extends CatalogRecordReference<K,F,R,A,RESOURCE,M>,A extends CatalogRecordAttributes<K,F,R,A,RESOURCE,M>,RESOURCE extends CatalogRecordResource<K,F,R,A,RESOURCE,M>,M extends CatalogRecordModel<K,F,R,A,RESOURCE,M>> extends RRKey.Builder<K,F,R,A,RESOURCE,M> {

        public Builder() {
            this.randomUUID = false;
        }
        @Override
        public RRKey.Builder<K, F, R, A, RESOURCE, M> setRandomUUID(boolean isRandomUUID) {
            if (isRandomUUID) {
                throw new RuntimeException("CatalogRecordKeys never have a randomUUID");
            }
            return this;
        }
    }
}
