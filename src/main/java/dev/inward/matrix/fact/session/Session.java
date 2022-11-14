package dev.inward.matrix.fact.session;

import dev.inward.matrix.fact.datum.Identity;
import dev.inward.matrix.fact.Fact;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.fact.notion.concept.dataSupplier.Unspoken;
import dev.inward.matrix.personality.Persona;
import dev.inward.matrix.fact.notion.person.Spirit;

public class Session extends Fact<Session, Identity.Ego<Context.Service>,Context.Service,Guest, Persona, Identity.Ego<Context.Service>, Spirit> {

    @Unspoken()
    private  String[] magicWords;

    public Session(Identity.Ego<Context.Service> id) {
        super(id);
    }


    public String[] getMagicWords() {
        return this.magicWords;
    }

}
