package dev.inward.matrix.datum.fact.notion.room;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Resource;
import dev.inward.matrix.datum.fact.notion.Industry;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.corpus.Corpus;
import dev.inward.matrix.datum.fact.notion.concept.corpus.Prophet;
import dev.inward.matrix.meta.Standard;

import java.util.Map;

public class Hotel extends Industry<Hotel,Room,Desk, Identity.Ego<Context.Service>,Context.Service,Cart,HouseKeeping, Corpus, Prophet> {
    public Hotel(HouseKeeping parent, Map<Standard<?, Room, Identity.Ego<Context.Service>, Context.Service>, Resource<Hotel, ?, ?, ?, Room, Desk, Identity.Ego<Context.Service>, Context.Service, Cart, HouseKeeping, Room, HouseKeeping>> resourceMap) {
        super(parent, resourceMap);
    }
}
