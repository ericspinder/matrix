package dev.inward.matrix.fact.authoritative.notion.room;

import dev.inward.matrix.Notion;
import dev.inward.matrix.Context;

public class Room extends Notion<Room, Identity.Ego, Context.Demarc,HouseKeeping> {
    public Room(Identity.Ego id) {
        super(id);
    }
}
