package dev.inward.matrix.datum.fact.notion.room;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Model;
import dev.inward.matrix.datum.fact.notion.concept.Context;

import java.lang.ref.ReferenceQueue;

public class HouseKeeping extends Model<Hotel, Room, Desk, Identity.Ego, Context.Demarc, Cart, HouseKeeping> {

    public HouseKeeping(Room fact, ReferenceQueue<Room> referenceQueue, Cart omnibus, Desk aspect) {
        super(fact, referenceQueue, omnibus, aspect);
    }
}
