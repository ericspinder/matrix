package dev.inward.matrix.fact.notion.room;

import dev.inward.matrix.fact.datum.Identity;
import dev.inward.matrix.fact.notion.Omnibus;
import dev.inward.matrix.fact.notion.concept.Context;

public class Cart extends Omnibus<Hotel,Room,Desk, Identity.Ego, Context.Demarc,Cart,HouseKeeping> {
    public Cart(Desk operational) {
        super(operational);
    }
}
