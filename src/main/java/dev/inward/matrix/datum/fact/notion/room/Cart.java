package dev.inward.matrix.datum.fact.notion.room;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.Omnibus;
import dev.inward.matrix.datum.fact.notion.concept.Context;

public class Cart extends Omnibus<Hotel,Room,Desk, Identity.Ego, Context.Demarc,Cart,HouseKeeping> {
    public Cart(Desk operational) {
        super(operational);
    }
}
