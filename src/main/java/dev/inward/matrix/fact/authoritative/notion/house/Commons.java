package dev.inward.matrix.fact.authoritative.notion.house;

import dev.inward.matrix.Context;
import dev.inward.matrix.fact.authoritative.notion.Omnibus;
import dev.inward.matrix.fact.authoritative.notion.concept.Construct;

public class Commons<H extends House<H,S>,S extends Steward<H,S>> extends Omnibus<House<H,S>,Builder<H,S>, Identity.Ghost, Context.Ethereal,Commons<H,S>,Steward<H,S>> {

    public Commons(Construct driver) {
        super(driver);
    }
}
