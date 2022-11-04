package dev.inward.matrix.domain;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.BitSet;

public class DnsFlags {
    public enum OPCode {
        QUERY (0),
        IQUERY(1),
        STATUS (2);
        final BitSet opCode;
        OPCode(Integer opCode) {
            this.opCode = BitSet.valueOf(ByteBuffer.allocate(4).order(ByteOrder.nativeOrder()).putInt(opCode));
        }
    }
    public enum ZeroCode {
        DEFAULT(BitSet.valueOf("000".getBytes(StandardCharsets.UTF_8)));

        final BitSet bitSet;
        ZeroCode(BitSet bitSet) {
            this.bitSet = bitSet;
        }
    }
    public enum MessageResponseCode {
        No_Error(0, "We're good"),
        Format_Error(1, "Query Format Error"),
        Name_Server_Error(2,"Server Failed"),
        Domain_Reference_Problem(3, "Domain does not exist"),
        Query_Type_Not_Supported(4, "Query Not supported"),
        Administratively_Prohibited(5, "You do not have access"),
        ;
        final BitSet bitSet;
        final String description;
        MessageResponseCode(int messageCode,String description) {
            this.bitSet = BitSet.valueOf(ByteBuffer.allocate(4).order(ByteOrder.nativeOrder()).putInt(messageCode));
            this.description = description;
        }
    }

    protected final BitSet flags;
    public DnsFlags(BitSet flags) {
        this.flags = flags;
    }
    public DnsFlags(OPCode opCode, boolean reply, boolean authoritative, boolean truncated, boolean recursion, boolean recursionAvailable, ZeroCode zeroCode, MessageResponseCode messageResponseCode){
        this.flags = new BitSet();
        this.flags.set(0,reply);
        this.flags.or(opCode.opCode);
        this.flags.set(5,authoritative);
        this.flags.set(6,truncated);
        this.flags.set(7,recursion);
        this.flags.set(8,recursionAvailable);
        this.flags.or(zeroCode.bitSet);
        this.flags.or(messageResponseCode.bitSet);
    }

    public boolean isReply() {
        return flags.get(0);
    }
    public OPCode getOpCode() {
        BitSet a = this.flags.get(1,4);
        for (OPCode opCode: OPCode.values()) {
            if (a.intersects(opCode.opCode)) {
                return opCode;
            }
        }
        return null;
    }

    /**
     * AA	Authoritative Answer, in a response, indicates if the DNS server is authoritative for the queried hostname	1
     * @return
     */
    protected boolean isAuthoritative() {
        return this.flags.get(5);
    }

    /**
     * TC	TrunCation, indicates that this message was truncated due to excessive length	1
     * @return
     */
    protected boolean isTruncated() {
        return this.flags.get(6);
    }
    protected boolean isRecursion() {
        return this.flags.get(7);
    } //RD	Recursion Desired, indicates if the client means a recursive query	1
    protected boolean isRecursionAvailable() {
        return this.flags.get(8);
    }  //RA	Recursion Available, in a response, indicates if the replying DNS server supports recursion	1
    protected ZeroCode getZero() {
        byte[] zero = this.flags.get(9, 13).toByteArray();
        for (ZeroCode zeroCode : ZeroCode.values()) {
            if (Arrays.compare(zeroCode.bitSet.toByteArray(), zero) == 0) {
                return zeroCode;
            }
        }
        return null;
    }
    protected MessageResponseCode getMessageResponseCode(){
        byte[] mrc = this.flags.get(13,17).toByteArray();
        for (MessageResponseCode messageResponseCode: MessageResponseCode.values()) {
            if (Arrays.compare(mrc,messageResponseCode.bitSet.toByteArray()) == 0) {
                return  messageResponseCode;
            }
        }
        return null;
    }
}
