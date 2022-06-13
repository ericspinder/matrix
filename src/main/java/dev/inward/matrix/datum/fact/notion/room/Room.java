package dev.inward.matrix.datum.fact.notion.room;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.Notion;
import dev.inward.matrix.datum.fact.notion.concept.Context;

public class Room extends Notion<Room, Identity.Ego<Context.Service>, Context.Service,HouseKeeping> {
    public Room(Identity.Ego<Context.Service> id) {
        super(id);
    }
}
