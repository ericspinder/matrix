/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package dev.inward.matrix.file.addressed.dns.startOfAuthority;

import dev.inward.matrix.file.addressed.dns.ResourceRecord;

public class StartOfAuthority extends ResourceRecord<StartOfAuthorityKey,StartOfAuthority,StartOfAuthorityView,StartOfAuthorityModel,StartOfAuthorityReference, StartOfAuthorityLibrarian> {

    protected final String responsibleEmailAddress;
    protected final int serial;
    protected final int refresh;
    protected final int retry;
    protected final int expire;

    public StartOfAuthority(StartOfAuthorityKey identity, int ttl, String responsibleEmailAddress, int serial, int refresh, int retry, int expire) {
        super(identity, ttl);
        this.ttl = ttl;
        this.responsibleEmailAddress = responsibleEmailAddress;
        this.serial = serial;
        this.refresh = refresh;
        this.retry = retry;
        this.expire = expire;
    }

    @Override
    public String toString() {
        return
                "ttl=" + ttl +
                ", responsibleEmailAddress='" + responsibleEmailAddress + '\'' +
                ", serial=" + serial +
                ", refresh=" + refresh +
                ", retry=" + retry +
                ", expire=" + expire;
    }
}
