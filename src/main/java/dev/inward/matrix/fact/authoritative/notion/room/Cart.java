package dev.inward.matrix.fact.authoritative.notion.room;

import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.authoritative.notion.Omnibus;
import dev.inward.matrix.fact.Context;

public class Cart extends Omnibus<Hotel,Room,Desk, Identity.Ego, Context.Demarc,Cart,HouseKeeping> {
    public Cart(Desk operational) {
        super(operational);
    }
}
