package dev.inward.matrix.phenomenon.io;

import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.engine.Zone;
import dev.inward.matrix.phenomenon.Phenomenon;
import dev.inward.matrix.phenomenon.SystemInitialization;
import dev.inward.matrix.phenomenon.Tolerances;
import dev.inward.matrix.datum.fact.threshold.Threshold;

import java.net.InetAddress;
import java.nio.channels.AsynchronousChannel;

public abstract class InputOutput<I extends InputOutput<I,CHANNEL,O>,CHANNEL extends AsynchronousChannel,O extends ChannelOption<CHANNEL>> extends Phenomenon<SystemInitialization,I, Tolerances.ThresholdTolerances> {

    protected final Threshold threshold;
    protected final CHANNEL channel;
    protected final Zone zone;

    public InputOutput(Context.Service demarc, Threshold threshold, Zone zone) {
        super(demarc,);
        this.threshold = threshold;
        this.zone = zone;
        this.channel = init();
    }
    protected abstract CHANNEL init();

    public final InetAddress getIpAddress() {
        return this.threshold.inetAddress();
    }
    public final CHANNEL getChannel() {
        return this.channel;
    }
    public final Zone getZone() {
        return this.zone;
    }
}
