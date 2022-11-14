package dev.inward.matrix.fact.notion.house;

import dev.inward.matrix.fact.datum.Identity;
import dev.inward.matrix.fact.notion.Notion;
import dev.inward.matrix.fact.notion.concept.Context;

public abstract class House<H extends House<H,S>,S extends Steward<H,S>> extends Notion<H,Identity.Ghost,Context.Ethereal,S> {

    public House(Identity.Ghost ghost) {
        super(ghost);
    }

}
