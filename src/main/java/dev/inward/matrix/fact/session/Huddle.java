package dev.inward.matrix.fact.session;

import dev.inward.matrix.fact.notion.advisor.Manager;
import dev.inward.matrix.fact.Bus;

public class Huddle extends Bus<Session,Huddle> {

    public Huddle(Manager management) {
        super(management);
    }
}
