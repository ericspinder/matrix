package dev.inward.matrix.fact.authoritative.notion.room;

import dev.inward.matrix.fact.Model;
import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.Context;

import java.lang.ref.ReferenceQueue;

public class HouseKeeping extends Model<Hotel, Room, Desk, Identity.Ego, Context.Demarc, Cart, HouseKeeping> {

    public HouseKeeping(Room fact, ReferenceQueue<Room> referenceQueue, Cart omnibus, Desk aspect) {
        super(fact, referenceQueue, omnibus, aspect);
    }
}
