package dev.inward.matrix.phenomenon.producer.communications;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.matter.report.DefaultFailure;
import dev.inward.matrix.phenomenon.Tolerances;

import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Network extends  {

    protected Identity.Ghost ghost;
    protected final InterfaceAddress interfaceAddress;
    protected final NetworkInterface networkInterface;

    public Network(Identity.Ego ego, Tolerances.NetworkTolerances tolerances, InterfaceAddress interfaceAddress, NetworkInterface networkInterface) {
        super(ego.getContext().ethereal(),tolerances);
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
            details.put("name",interfaceAddress.getAddress().getCanonicalHostName());
            ThreadedConcept.threadedConcept.get().report(new DefaultFailure(UUID.randomUUID(), ghost, Instant.now(),"Socket Exception failed to be 'up'",details));
        }
        return false;
    }

    @Override
    public int compareTo(Network o) {
        return 0;
    }
}
