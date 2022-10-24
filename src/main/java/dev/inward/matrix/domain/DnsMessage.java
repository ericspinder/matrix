package dev.inward.matrix.domain;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class DnsMessage {
    public enum OPCode {
        QUERY (0),
        IQUERY(1),
        STATUS (2);
        byte[] opCode;
        OPCode(Integer opCode) {
            this.opCode = ByteBuffer.allocate(4).order(ByteOrder.nativeOrder()).putInt(opCode).array();
        }
    }
    protected boolean isReply; //QR	Indicates if the message is a query (0) or a reply (1)	1
    protected OPCode opCode;
    protected boolean isAuthoritative; //AA	Authoritative Answer, in a response, indicates if the DNS server is authoritative for the queried hostname	1
    protected boolean truncated; //TC	TrunCation, indicates that this message was truncated due to excessive length	1
    protected boolean recursion; //RD	Recursion Desired, indicates if the client means a recursive query	1
    protected boolean recursionAvaiable;  //RA	Recursion Available, in a response, indicates if the replying DNS server supports recursion	1
    protected byte[] zero; //Z	Zero, reserved for future use	3
    protected byte[] responseCode; //RCODE	Response code, can be NOERROR (0), FORMERR (1, Format error), SERVFAIL (2), NXDOMAIN (3, Nonexistent domain), etc.[35]	4
}
