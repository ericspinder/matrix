package dev.inward.matrix.Agent;

import javax.security.auth.Subject;
import java.security.Principal;

public class Agent {

    private Subject subject = new Subject();

    public Agent(Principal principal) {
        this.subject.getPrincipals().add(principal);
    }
    public Subject getSubject() {
        return subject;
    }
}
