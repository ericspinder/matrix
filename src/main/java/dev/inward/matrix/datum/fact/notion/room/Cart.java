package dev.inward.matrix.datum.fact.notion.room;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.Omnibus;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.corpus.Corpus;
import dev.inward.matrix.datum.fact.notion.concept.corpus.Prophet;

public class Cart extends Omnibus<Hotel,Room,Desk, Identity.Ego<Context.Service>,Context.Service,Cart,HouseKeeping, Corpus, Prophet> {
    public Cart(Desk operational) {
        super(operational);
    }
}
