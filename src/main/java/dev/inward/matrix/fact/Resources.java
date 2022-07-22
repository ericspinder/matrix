package dev.inward.matrix.fact;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.fact.notion.persona.Persona;
import dev.inward.matrix.meta.Standard;
import dev.inward.matrix.operational.Operational;

import java.security.PermissionCollection;
import java.util.LinkedHashMap;

public class Resources<Y extends Factory<Y,F,O,I,X,B,P,?,?,?,?,?>,F extends Fact<F,I,X,P>,O extends Operational<Y,F,O,I,X,B,P>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<Y,F,O,I,X,B,P>,P extends Diplomat<Y,F,O,I,X,B,P>> extends LinkedHashMap<Standard<?,F,I,X>,Resource<Y,?,?,?,F,O,I,X,B,P>> {

    protected final PermissionCollection permissions;
    protected final Persona[] principals;
}
