package dev.inward.matrix.phenomenon.io;

import dev.inward.matrix.fact.Fact;
import dev.inward.matrix.fact.authoritative.Governance;
import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.threshold.Threshold;

import java.net.InetAddress;
import java.nio.channels.AsynchronousChannel;

public abstract class InputOutput<IO extends InputOutput<IO,CHANNEL>,CHANNEL extends AsynchronousChannel> extends Fact<IO, Identity.Ego, Governance.Ethereal> {

    protected final Threshold threshold;
    protected final CHANNEL channel;

    public InputOutput(Governance.Ethereal ethereal, Threshold threshold) {
        super(new Identity.Ego(Identity.Empty,ethereal));
        this.threshold = threshold;
        this.channel = init();
    }
    protected abstract CHANNEL init();

    public final InetAddress getIpAddress() {
        return this.threshold.inetAddress();
    }
    public final CHANNEL getChannel() {
        return this.channel;
    }

}
