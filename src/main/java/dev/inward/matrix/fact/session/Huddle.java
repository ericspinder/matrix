package dev.inward.matrix.fact.session;

import dev.inward.matrix.fact.Bus;
import dev.inward.matrix.fact.authoritative.notion.advisor.Manager;

public class Huddle extends Bus<Session,Huddle> {

    public Huddle(Manager management) {
        super(management);
    }
}
