/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.resource.record.startOfAuthority;

import dev.inward.matrix.file.resource.record.DnsDirectoryKey;
import dev.inward.matrix.file.resource.record.RRKey;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;

public class StartOfAuthorityKey extends RRKey<StartOfAuthority,StartOfAuthorityKey,StartOfAuthorityView,StartOfAuthorityModel,StartOfAuthorityReference,StartOfAuthorityLibrarian> {
    protected StartOfAuthorityKey(URI uri, UUID uuid,boolean randomUUID) {
        super(uri, uuid,randomUUID);
    }

    public static class Builder extends RRKey.Builder<StartOfAuthority,StartOfAuthorityKey,StartOfAuthorityView,StartOfAuthorityModel,StartOfAuthorityReference,StartOfAuthorityLibrarian> {

        @Override
        protected String completeUri() throws URISyntaxException {
            return null;
        }

        @Override
        protected StartOfAuthorityKey newMatrixKey() {
            return new StartOfAuthorityKey(this.uri,this.uuid,randomUUID);
        }
    }
}
