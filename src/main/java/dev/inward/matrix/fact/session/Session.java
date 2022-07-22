package dev.inward.matrix.fact.session;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.fact.Fact;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.fact.notion.concept.dataSupplier.Unspoken;
import dev.inward.matrix.fact.notion.persona.Persona;
import dev.inward.matrix.fact.notion.persona.Spirit;

public class Session extends Fact<Session, Identity.Ego<Context.Service>,Context.Service,Guest,Persona, Identity.Ego<Context.Service>, Spirit> {

    @Unspoken()
    private  String[] magicWords;

    public Session(Identity.Ego<Context.Service> id) {
        super(id);
    }


    public String[] getMagicWords() {
        return this.magicWords;
    }

}
