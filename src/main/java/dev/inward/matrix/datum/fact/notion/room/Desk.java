package dev.inward.matrix.datum.fact.notion.room;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.Aspect;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.corpus.Corpus;
import dev.inward.matrix.datum.fact.notion.concept.corpus.Prophet;
import dev.inward.matrix.operational.Specification;
import dev.inward.matrix.operational.Supplier;

public class Desk extends Aspect<Hotel,Room,Desk, Identity.Ego<Context.Service>,Context.Service,Cart,HouseKeeping, Corpus, Prophet> {
    public Desk(Specification specification, Supplier<Hotel, Room, Desk, Identity.Ego<Context.Service>, Context.Service, Cart, HouseKeeping, Room, HouseKeeping> supplier) {
        super(specification, supplier);
    }
}
