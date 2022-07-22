package dev.inward.matrix.fact.notion.recorder.dns;

import dev.inward.matrix.agent.Edition;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.fact.notion.recorder.Recorder;

public class DnsExchange<E extends Edition<E>,I extends Identity<I,X>,X extends Context<X>> extends Recorder<DnsMessage<E,I,X>,DnsMessage<E,I,X>,I,X> {


    public DnsExchange(Identity.Ego id) {
        super(id);
    }

    @Override
    public DnsMessage<E, I, X> process(DnsMessage<E, I, X> matter) {
        return null;
    }
}
