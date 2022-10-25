package dev.inward.matrix.datum.fact.notion.room;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.house.Assembly;
import dev.inward.matrix.datum.fact.notion.house.Steward;
import dev.inward.matrix.resources.Resource;
import dev.inward.matrix.resources.Storage;
import dev.inward.matrix.datum.fact.notion.Industry;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.corpus.*;
import dev.inward.matrix.datum.Standard;

import java.util.Map;

public class Hotel extends Industry<Hotel,Room,Desk, Identity.Id.Ego, Context.Demarc,Cart,HouseKeeping, Assembly,Corpus, Mechanical, Sandbox, Steward> {

    public Hotel(Steward mortal, Storage storage, Map<Standard<?, Room, Identity.Id.Ego, Context.Demarc>, Resource<Hotel, ?, ?, ?, Room, Desk, Identity.Id.Ego, Context.Demarc, Cart, HouseKeeping>> standardResourcesMap) {
        super(mortal, storage, standardResourcesMap);
    }
}
