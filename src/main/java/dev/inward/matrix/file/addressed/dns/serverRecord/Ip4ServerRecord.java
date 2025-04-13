/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.dns.serverRecord;

import java.net.InetAddress;

public class Ip4ServerRecord extends ServerRecord<Ip4ServerRecordLibrarian,Ip4ServerRecordKey,Ip4ServerRecord,Ip4ServerRecordView,Ip4ServerRecordModel,Ip4ServerRecordReference, Ip4ServerRecordSteward> {
    public Ip4ServerRecord(Ip4ServerRecordKey key, InetAddress inetAddress, int ttl) {
        super(key, inetAddress, ttl);
    }

}
