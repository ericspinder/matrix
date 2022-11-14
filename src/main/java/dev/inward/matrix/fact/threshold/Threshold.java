package dev.inward.matrix.fact.threshold;

import dev.inward.matrix.fact.datum.Identity;
import dev.inward.matrix.fact.Fact;
import dev.inward.matrix.fact.matter.report.DefaultFailure;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.phenomenon.producer.communications.ThreadedConcept;

import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Threshold extends Fact<Threshold, Identity.Ghost, Context.Ethereal> {

    protected final InterfaceAddress interfaceAddress;
    protected final NetworkInterface networkInterface;

    public Threshold(Identity.Ghost ego,InterfaceAddress interfaceAddress, NetworkInterface networkInterface) {
        super(ego);
        this.interfaceAddress = interfaceAddress;
        this.networkInterface = networkInterface;

    }

    public final InterfaceAddress interfaceAddress() {
        return this.interfaceAddress;
    }
    public final InetAddress inetAddress() {
        return this.interfaceAddress.getAddress();
    }
    public final boolean isVirtual() {
        return this.networkInterface.isVirtual();
    }
    public final boolean isUp() {
        try {
            return this.networkInterface.isUp();
        }
        catch (SocketException se) {
            Map<String,Object> details = new HashMap<>();
            details.put("exception message",se.getMessage());
            details.put("NetworkInterface", networkInterface.toString());
            details.put("IpAddress",interfaceAddress.getAddress().getHostAddress());
            details.put("na me",interfaceAddress.getAddress().getCanonicalHostName());
            ThreadedConcept.threadedConcept.get().report(new DefaultFailure(UUID.randomUUID(), this.identity, Instant.now(),"Socket Exception failed to be 'up'",details));
        }
        return false;
    }

    @Override
    public int compareTo(Threshold o) {
        return 0;
    }
}
