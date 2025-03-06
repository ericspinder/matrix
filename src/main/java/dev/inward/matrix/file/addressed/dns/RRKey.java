/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package dev.inward.matrix.file.addressed.dns;

import dev.inward.matrix.file.addressed.AddressedKey;
import dev.inward.matrix.file.DirectoryKey;

import java.net.URI;
import java.net.URL;
import java.util.UUID;

public class RRKey<K extends RRKey<K,F,R,A,RESOURCE,M>,F extends ResourceRecord<K,F,R,A,RESOURCE,M>,R extends RRReference<K,F,R,A,RESOURCE,M>,A extends RRAttributes<K,F,R,A,RESOURCE,M>,RESOURCE extends RRResource<K,F,R,A,RESOURCE,M>,M extends RRModel<K,F,R,A,RESOURCE,M>> extends AddressedKey<DnsScheme, DnsLibraryKey,DnsLibrary, DnsPath,DnsCatalogKey,DnsCatalog,DnsDirectoryKey,DnsDirectory,DnsDirectoryReference,DnsDirectoryAttributes,DnsDirectoryResource,DnsDirectoryModel,UUID,K,F,R,A,RESOURCE,M> {

    protected final boolean randomUUID;
    protected RRKey(URI uri, UUID uuid, DnsDirectoryKey directoryKey, boolean randomUUID) {
        super(uri, uuid, directoryKey);
        this.randomUUID = randomUUID;
    }

    public boolean isRandomUUID() {
        return randomUUID;
    }

    public static abstract class Builder<K extends RRKey<K,F,R,A,RESOURCE,M>,F extends ResourceRecord<K,F,R,A,RESOURCE,M>,R extends RRReference<K,F,R,A,RESOURCE,M>,A extends RRAttributes<K,F,R,A,RESOURCE,M>,RESOURCE extends RRResource<K,F,R,A,RESOURCE,M>,M extends RRModel<K,F,R,A,RESOURCE,M>> extends AddressedKey.Builder<DnsScheme, DnsLibraryKey,DnsLibrary, DnsPath,DnsCatalogKey,DnsCatalog,DnsDirectoryKey,DnsDirectory,DnsDirectoryReference,DnsDirectoryAttributes,DnsDirectoryResource,DnsDirectoryModel,UUID,K,F,R,A,RESOURCE,M> {

        protected boolean randomUUID;

        public Builder<K,F,R,A,RESOURCE,M> setRandomUUID(boolean isRandomUUID) {
            this.randomUUID = isRandomUUID;
            return this;
        }
    }

}
