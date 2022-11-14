package dev.inward.matrix.phenomenon.io;

import dev.inward.matrix.fact.Fact;
import dev.inward.matrix.fact.datum.Identity;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.engine.Zone;
import dev.inward.matrix.phenomenon.Phenomenon;
import dev.inward.matrix.phenomenon.SystemInitialization;
import dev.inward.matrix.phenomenon.Tolerances;
import dev.inward.matrix.fact.threshold.Threshold;

import java.net.InetAddress;
import java.nio.channels.AsynchronousChannel;
import java.util.UUID;

public abstract class InputOutput<IO extends InputOutput<IO,CHANNEL>,CHANNEL extends AsynchronousChannel> extends Fact<IO, Identity.Ego, Context.Ethereal> {

    protected final Threshold threshold;
    protected final CHANNEL channel;

    public InputOutput(Context.Ethereal ethereal, Threshold threshold) {
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
