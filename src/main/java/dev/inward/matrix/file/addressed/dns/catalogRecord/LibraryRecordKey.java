/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.dns.catalogRecord;

import dev.inward.matrix.control.authority.Authority;
import dev.inward.matrix.file.userInfo.record.DnsDirectoryKey;
import dev.inward.matrix.file.addressed.dns.RRKey;

import java.net.URI;
import java.util.UUID;

public class LibraryRecordKey extends RRKey<LibraryRecord, LibraryRecordKey, LibraryRecordView, LibraryRecordModel, LibraryRecordReference, LibraryRecordLibrarian> {

    protected final String protocolString;
    protected LibraryRecordKey(URI uri, UUID uuid, Authority directoryKey, String protocolString) {
        super(uri, uuid, directoryKey,false);
        this.protocolString = protocolString;
    }

    public static class Builder extends RRKey.Builder<LibraryRecord, LibraryRecordKey, LibraryRecordView, LibraryRecordModel, LibraryRecordReference, LibraryRecordLibrarian> {

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
