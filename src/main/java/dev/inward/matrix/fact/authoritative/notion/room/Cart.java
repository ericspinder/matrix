package dev.inward.matrix.fact.authoritative.notion.room;

import dev.inward.matrix.Identity;
import dev.inward.matrix.fact.authoritative.notion.Omnibus;
import dev.inward.matrix.Context;

public class Cart extends Omnibus<Hotel,Room,Desk, Identity.Ego, Context.Demarc,Cart,HouseKeeping> {
    public Cart(Desk operational) {
        super(operational);
    }
}
