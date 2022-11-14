package dev.inward.matrix.fact.notion.room;

import dev.inward.matrix.fact.datum.Identity;
import dev.inward.matrix.fact.notion.Aspect;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.fact.Specification;
import dev.inward.matrix.resources.Supplier;

import java.security.ProtectionDomain;

public class Desk extends Aspect<Hotel,Room,Desk, Identity.Ego, Context.Demarc,Cart,HouseKeeping> {

    public Desk(Specification specification, Supplier<Hotel, Room, Desk, Identity.Ego, Context.Demarc, Cart, HouseKeeping, ?, ?, ?, ?, ?> supplier, ProtectionDomain protectionDomain) {
        super(specification, supplier, protectionDomain);
    }
}
