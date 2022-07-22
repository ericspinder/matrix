package dev.inward.matrix.fact.notion.room;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.fact.notion.Aspect;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.operational.Specification;
import dev.inward.matrix.operational.Supplier;

import java.security.ProtectionDomain;

public class Desk extends Aspect<Hotel,Room,Desk, Identity.Ego,Context.JVM,Cart,HouseKeeping> {

    public Desk(Specification specification, Supplier<Hotel, Room, Desk, Identity.Ego, Context.JVM, Cart, HouseKeeping, ?, ?, ?, ?, ?> supplier, ProtectionDomain protectionDomain) {
        super(specification, supplier, protectionDomain);
    }
}
