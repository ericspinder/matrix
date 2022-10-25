package dev.inward.matrix.datum.fact.notion.house;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.Omnibus;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.Mortal;

public class Commons<H extends House<H,S>,S extends Steward<H,S>> extends Omnibus<House<H,S>,Builder<H,S>, Identity.Ghost, Context.Ethereal,Commons<H,S>,Steward<H,S>> {

    public Commons(Mortal driver) {
        super(driver);
    }
}
