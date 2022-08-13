package dev.inward.matrix.datum.fact.notion.room;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.operational.induction.Resource;
import dev.inward.matrix.operational.induction.Resources;
import dev.inward.matrix.datum.fact.notion.Industry;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.corpus.*;
import dev.inward.matrix.meta.Standard;

import java.util.Map;

public class Hotel extends Industry<Hotel,Room,Desk, Identity.Id.Ego,Context.JVM,Cart,HouseKeeping,Assembly,Corpus, Mechanical, Sandbox,Prophet> {

    public Hotel(Prophet mortal, Resources resources, Map<Standard<?, Room, Identity.Id.Ego, Context.JVM>, Resource<Hotel, ?, ?, ?, Room, Desk, Identity.Id.Ego, Context.JVM, Cart, HouseKeeping>> standardResourcesMap) {
        super(mortal, resources, standardResourcesMap);
    }
}
