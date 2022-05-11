package dev.inward.matrix.datum.fact.notion.concept.boot;

import dev.inward.matrix.Agent.PlatformAgent;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Concept;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.operational.IntegerOption;

import java.security.Security;

public final class Boot extends Concept<Boot, Context.JVM, Root> {

    @IntegerOption.IntegerDefault(IntegerOption.DnsTimeout)



    public Boot(Identity.Ego<Context.JVM> id, PlatformAgent agent) {
        super(id);
        this.agent = agent;
        String ttlString = Security.getProperty(TTL_PROP);
        if (ttlString == null || Integer.parseInt(ttlString) < dnsTimeout) {
            Security.setProperty(TTL_PROP, dnsTimeout.toString());
        }
    }


    public PlatformAgent getAgent() {
        return this.agent;
    }
}
