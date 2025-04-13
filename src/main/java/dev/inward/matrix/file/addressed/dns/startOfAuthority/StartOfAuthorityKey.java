/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.dns.startOfAuthority;

import dev.inward.matrix.file.addressed.dns.DnsDirectoryKey;
import dev.inward.matrix.file.addressed.dns.RRKey;

import java.net.URI;
import java.util.UUID;

public class StartOfAuthorityKey extends RRKey<StartOfAuthorityLibrarian,StartOfAuthorityKey,StartOfAuthority,StartOfAuthorityView,StartOfAuthorityModel,StartOfAuthorityReference, StartOfAuthoritySteward> {
    protected StartOfAuthorityKey(URI uri, UUID uuid, DnsDirectoryKey directoryKey,boolean randomUUID) {
        super(uri, uuid, directoryKey,randomUUID);
    }

    public static class Builder extends RRKey.Builder<StartOfAuthorityLibrarian,StartOfAuthorityKey,StartOfAuthority,StartOfAuthorityView,StartOfAuthorityModel,StartOfAuthorityReference, StartOfAuthoritySteward> {

        @Override
        protected StartOfAuthorityKey newMatrixKey() {
            return new StartOfAuthorityKey(this.uri,this.id,this.directoryKey,randomUUID);
        }
    }
}
