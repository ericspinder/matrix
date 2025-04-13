/*
 *  Pinder's Matrix © 2025. by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package dev.inward.matrix.file.addressed.dns.serverRecord;

import dev.inward.matrix.file.addressed.dns.DnsDirectoryKey;
import dev.inward.matrix.file.addressed.dns.ResourceRecordParser;

public abstract class ServerRecordParser<LB extends ServerRecordLibrarian<LB,K,F,V,M,R,G>, K extends ServerRecordKey<LB,K,F,V,M,R,G>,F extends ServerRecord<LB,K,F,V,M,R,G>,V extends ServerRecordView<LB,K,F,V,M,R,G>,M extends ServerRecordModel<LB,K,F,V,M,R,G>,R extends ServerRecordReference<LB,K,F,V,M,R,G>,G extends ServerRecordSteward<LB,K,F,V,M,R,G>> extends ResourceRecordParser<LB,K,F,V,M,R,G> {
    public ServerRecordParser(DnsDirectoryKey dnsDirectoryKey) {
        super(dnsDirectoryKey);
    }
}
