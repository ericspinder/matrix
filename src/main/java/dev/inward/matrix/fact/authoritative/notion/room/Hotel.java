package dev.inward.matrix.fact.authoritative.notion.room;

import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.datum.Standard;
import dev.inward.matrix.fact.authoritative.notion.Industry;
import dev.inward.matrix.fact.Context;
import dev.inward.matrix.fact.authoritative.notion.concept.corpus.Corpus;
import dev.inward.matrix.fact.authoritative.notion.concept.corpus.Mechanical;
import dev.inward.matrix.fact.authoritative.notion.concept.corpus.Sandbox;
import dev.inward.matrix.fact.authoritative.notion.house.Assembly;
import dev.inward.matrix.fact.authoritative.notion.house.Steward;
import dev.inward.matrix.resources.Resource;
import dev.inward.matrix.resources.Storage;

import java.util.Map;

public class Hotel extends Industry<Hotel,Room,Desk, Identity.WebPage.Ego, Context.Demarc,Cart,HouseKeeping, Assembly,Corpus, Mechanical, Sandbox, Steward> {

    public Hotel(Steward mortal, Storage storage, Map<Standard<?, Room, Identity.WebPage.Ego, Context.Demarc>, Resource<Hotel, ?, ?, ?, Room, Desk, Identity.WebPage.Ego, Context.Demarc, Cart, HouseKeeping>> standardResourcesMap) {
        super(mortal, storage, standardResourcesMap);
    }
}
