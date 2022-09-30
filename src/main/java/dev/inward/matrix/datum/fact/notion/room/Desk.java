package dev.inward.matrix.datum.fact.notion.room;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.Aspect;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.Specification;
import dev.inward.matrix.resources.Supplier;

import java.security.ProtectionDomain;

public class Desk extends Aspect<Hotel,Room,Desk, Identity.Ego, Context.Ethereal,Cart,HouseKeeping> {

    public Desk(Specification specification, Supplier<Hotel, Room, Desk, Identity.Ego, Context.Ethereal, Cart, HouseKeeping, ?, ?, ?, ?, ?> supplier, ProtectionDomain protectionDomain) {
        super(specification, supplier, protectionDomain);
    }
}
