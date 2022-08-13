package dev.inward.matrix.operational.induction;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Bus;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.datum.fact.Representative;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.persona.Persona;
import dev.inward.matrix.factory.Factory;
import dev.inward.matrix.meta.Standard;
import dev.inward.matrix.operational.Operational;

import java.util.Map;

public class Resources<Y extends Factory<Y,F,O,I,X,B,R,IC,XC>,F extends Fact<F,I,X,R,IC,XC>,O extends Operational<Y,F,O,I,X,B,R,IC,XC>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<Y,F,O,I,X,B,R,IC,XC>,R extends Representative<F,I,X,R,IC,XC>,IC extends Identity<IC,XC>,XC extends Context<XC>> {

    protected final NotionProtectionDomain notionProtectionDomain;

    protected final Map<Standard<?,F,I,X>, Resource<?,?,?,F,I,X,R,IC,XC>> standardResourcesMap;

    public Resources(Persona[] personas, Map<Standard<?,F,I,X>, Resource<?,?,?,F,I,X,R,IC,XC>> standardResourcesMap) {
        this.personas = personas;
        this.standardResourcesMap = standardResourcesMap;
    }

}
