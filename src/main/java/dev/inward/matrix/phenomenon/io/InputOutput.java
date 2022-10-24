package dev.inward.matrix.phenomenon.io;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.engine.Role;
import dev.inward.matrix.phenomenon.Phenomenon;
import dev.inward.matrix.phenomenon.SystemInitialization;
import dev.inward.matrix.phenomenon.Tolerances;
import dev.inward.matrix.phenomenon.producer.communications.Network;

import java.net.InetAddress;
import java.nio.channels.AsynchronousChannel;
import java.time.Duration;

public abstract class InputOutput<I extends InputOutput<I,CHANNEL,O>,CHANNEL extends AsynchronousChannel,O extends ChannelOption<CHANNEL>> extends Phenomenon<SystemInitialization,I, Tolerances.NetworkTolerances> {

    protected final Identity.Ego ego;
    protected final Network network;
    protected final CHANNEL channel;
    protected final Role role;

    public InputOutput(Context.Demarc demarc, Network network, Role role) {
        super(demarc.ethereal(), network.tolerances());
        this.network = network;
        this.role = role;
        this.channel = init();
    }
    protected abstract CHANNEL init();

    public final InetAddress getIpAddress() {
        return this.network.inetAddress();
    }
    public final CHANNEL getChannel() {
        return this.channel;
    }
    public final Role role() {
        return this.role;
    }
}
