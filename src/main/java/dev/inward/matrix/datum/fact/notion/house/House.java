package dev.inward.matrix.datum.fact.notion.house;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.Notion;
import dev.inward.matrix.datum.fact.notion.concept.Context;

public abstract class House<H extends House<H,S>,S extends Steward<H,S>> extends Notion<H,Identity.Ghost,Context.Ethereal,S> {

    public House(Identity.Ghost ghost) {
        super(ghost);
    }

}
