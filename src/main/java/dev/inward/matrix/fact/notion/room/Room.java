package dev.inward.matrix.fact.notion.room;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.fact.notion.Notion;
import dev.inward.matrix.fact.notion.concept.Context;

public class Room extends Notion<Room, Identity.Ego, Context.JVM,HouseKeeping> {
    public Room(Identity.Ego id) {
        super(id);
    }
}
