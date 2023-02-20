package dev.inward.matrix.fact.session;

import dev.inward.matrix.fact.Fact;
import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.Context;
import dev.inward.matrix.fact.authoritative.notion.concept.dataSupplier.Unspoken;
import dev.inward.matrix.fact.authoritative.yard.Spirit;
import dev.inward.matrix.fact.authoritative.yard.Tree;

public class Session extends Fact<Session, Identity.Ego<Context.Path>, Context.Path,Guest, Tree, Identity.Ego<Context.Path>, Spirit> {

    @Unspoken()
    private  String[] magicWords;

    public Session(Identity.Ego<Context.Path> id) {
        super(id);
    }


    public String[] getMagicWords() {
        return this.magicWords;
    }

}
