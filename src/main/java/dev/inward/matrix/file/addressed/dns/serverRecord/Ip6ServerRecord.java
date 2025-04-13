/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.dns.serverRecord;

import java.net.InetAddress;

public class Ip6ServerRecord extends ServerRecord<Ip6ServerRecordLibrarian,Ip6ServerRecordKey,Ip6ServerRecord,Ip6ServerRecordView,Ip6ServerRecordModel,Ip6ServerRecordReference, Ip6ServerRecordSteward> {
    public Ip6ServerRecord(Ip6ServerRecordKey key, InetAddress inetAddress, int ttl) {
        super(key, inetAddress, ttl);
    }
}
