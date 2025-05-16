/*
 *  Copyright (c) © 2025. Pinder's Matrix  by Eric S Pinder is licensed under Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package dev.inward.matrix.file.resource.record;

public class DnsQuery extends DnsFlags {


    public DnsQuery(boolean reply, boolean authoritative, boolean truncated, boolean recursion, boolean recursionAvailable, ZeroCode zeroCode, MessageResponseCode messageResponseCode) {
        super(OPCode.QUERY, reply, authoritative, truncated, recursion, recursionAvailable, zeroCode, messageResponseCode);
    }

}
