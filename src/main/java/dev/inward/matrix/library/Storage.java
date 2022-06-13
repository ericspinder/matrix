package dev.inward.matrix.library;

import dev.inward.matrix.Agent.Edition;
import dev.inward.matrix.datum.Datum;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.*;
import dev.inward.matrix.datum.fact.notion.Ambassador;
import dev.inward.matrix.datum.fact.notion.Notion;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.persona.Persona;
import dev.inward.matrix.operational.Operational;
import dev.inward.matrix.operational.Supplier;
import dev.inward.matrix.rubric.Criteria;
import dev.inward.matrix.rubric.Envoy;

import java.security.PermissionCollection;
import java.security.ProtectionDomain;

public class Storage<Y extends Factory<Y,F,O,I,X,B,P>,F extends Fact<F,I,X,P>,O extends Operational<Y,F,O,I,X,B,P>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<Y,F,O,I,X,B,P>,P extends Diplomat<Y,F,O,I,X,B,P>> extends ProtectionDomain {

    public Storage(Edition<?> edition, PermissionCollection permissions, ClassLoader classloader, Persona[] principals) {
        super(edition, permissions, classloader, principals);
    }

    public <DATUM,D extends Datum<DATUM,D,E,F,I,X,P>,E extends Envoy<DATUM,D,E,F,I,X,P>> E checkout(D datum, Y factory) {
        Supplier<Y,F,O,I,X,B,P> supplier = factory.getEngine().getOperational().getSupplier();
        return supplier.buildEnvoy(datum,factory);
    }
    public Edition<?> getEdition() {
        return (Edition<?>) this.getCodeSource();
    }

}
