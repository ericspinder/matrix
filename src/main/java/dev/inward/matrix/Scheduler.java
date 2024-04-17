package dev.inward.matrix;

import dev.inward.matrix.fact.Specification;
import dev.inward.matrix.concept.matter.messaging.Scratch;
import dev.inward.matrix.resources.Supplier;

import java.nio.channels.AsynchronousChannel;
import java.security.ProtectionDomain;

public class Scheduler<S extends Scheme<S,L>,L extends Library<S,L>,SCHEDULER extends Scheduler<S,L,SCHEDULER,CHANNEL,C>,CHANNEL extends AsynchronousChannel,C extends Clerk<S,L,CHANNEL,C> > {


    public Scheduler(Specification specification, tectionDomain protectionDomain) {
        super(specification, supplier, protectionDomain);
    }
}
