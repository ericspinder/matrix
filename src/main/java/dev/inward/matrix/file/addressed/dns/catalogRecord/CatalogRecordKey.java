/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.dns.catalogRecord;

import dev.inward.matrix.file.addressed.dns.DnsDirectoryKey;
import dev.inward.matrix.file.addressed.dns.RRKey;

import java.net.URI;
import java.util.UUID;

public class CatalogRecordKey<K extends CatalogRecordKey<K,F,V,M,R,B>,F extends CatalogRecord<K,F,V,M,R,B>,V extends CatalogRecordView<K,F,V,M,R,B>,M extends CatalogRecordModel<K,F,V,M,R,B>,R extends CatalogRecordReference<K,F,V,M,R,B>,B extends CatalogRecordLibrarian<K,F,V,M,R,B>> extends RRKey<K,F,V,M,R,B> {
    protected CatalogRecordKey(URI uri, UUID uuid, DnsDirectoryKey directoryKey) {
        super(uri, uuid, directoryKey,false);
    }

    public static abstract class Builder<K extends CatalogRecordKey<K,F,V,M,R,B>,F extends CatalogRecord<K,F,V,M,R,B>,V extends CatalogRecordView<K,F,V,M,R,B>,M extends CatalogRecordModel<K,F,V,M,R,B>,R extends CatalogRecordReference<K,F,V,M,R,B>,B extends CatalogRecordLibrarian<K,F,V,M,R,B>> extends RRKey.Builder<K,F,V,M,R,B> {

        public Builder() {
            this.randomUUID = false;
        }
        @Override
        public RRKey.Builder<K,F,V,M,R,B> setRandomUUID(boolean isRandomUUID) {
            if (isRandomUUID) {
                throw new RuntimeException("CatalogRecordKeys never have a randomUUID");
            }
            return this;
        }
    }
}
