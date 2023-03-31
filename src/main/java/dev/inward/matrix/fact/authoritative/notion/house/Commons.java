package dev.inward.matrix.fact.authoritative.notion.house;

import dev.inward.matrix.fact.Context;
import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.authoritative.notion.Omnibus;
import dev.inward.matrix.fact.authoritative.notion.concept.Mortal;

public class Commons<H extends House<H,S>,S extends Steward<H,S>> extends Omnibus<House<H,S>,Builder<H,S>, Identity.Ghost, Context.Ethereal,Commons<H,S>,Steward<H,S>> {

    public Commons(Mortal driver) {
        super(driver);
    }
}
