package dev.inward.matrix.datum.fact.session;

import dev.inward.matrix.advisor.Manager;
import dev.inward.matrix.datum.fact.Bus;

public class Huddle extends Bus<Session,Huddle> {

    public Huddle(Manager management) {
        super(management);
    }
}
