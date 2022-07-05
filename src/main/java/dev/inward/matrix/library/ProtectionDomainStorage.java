package dev.inward.matrix.library;

import dev.inward.matrix.agent.Edition;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.*;
import dev.inward.matrix.datum.fact.notion.concept.*;
import dev.inward.matrix.datum.fact.notion.persona.Persona;

import java.security.PermissionCollection;
import java.security.ProtectionDomain;

public class ProtectionDomainStorage<Y extends Industry<Y,N,S,I,X,O,A,?,?,?,?,?>,N extends Notion<N,I,X,A>,S extends Aspect<Y,N,S,I,X,O,A>,I extends Identity<I,X>,X extends Context<X>,O extends Omnibus<Y,N,S,I,X,O,A>,A extends Ambassador<Y,N,S,I,X,O,A>> extends ProtectionDomain {

    public ProtectionDomainStorage(Edition<?> edition, PermissionCollection permissions, ClassLoader classloader, Persona[] principals) {
        super(edition, permissions, classloader, principals);
    }

    public Edition<?> getEdition() {
        return (Edition<?>) this.getCodeSource();
    }

}
