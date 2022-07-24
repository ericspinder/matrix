package dev.inward.matrix.fact.notion.interaction.dns;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.fact.notion.interaction.Interaction;

public class DnsInteraction<II extends Identity<II,XI>,XI extends Context<XI>> extends Interaction<DnsInteraction<II,XI>,DnsMessage<II,XI>,DnsMessage<II,XI>,II,XI> {


    public DnsInteraction(Identity.Ego id) {
        super(id);
    }

    @Override
    public DnsMessage<II, XI> process(DnsMessage<II, XI> matter) {
        return null;
    }

}
