package dev.inward.matrix.datum.fact.notion.room;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Context;

import java.lang.ref.ReferenceQueue;

public class HouseKeeping extends dev.inward.matrix.datum.fact.Diplomat<Hotel, Room, Desk, Identity.Ego, Context.JVM, Cart, HouseKeeping> {

    public HouseKeeping(Room fact, ReferenceQueue<Room> referenceQueue, Cart omnibus, Desk aspect) {
        super(fact, referenceQueue, omnibus, aspect);
    }
}
