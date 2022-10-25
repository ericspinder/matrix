package dev.inward.matrix.datum.fact.notion.house;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.Notion;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.house.ziggurat.Ziggurat;
import dev.inward.matrix.domain.Authority;
import dev.inward.matrix.engine.Zone;
import dev.inward.matrix.resources.OSinfo;

public class House<H extends House<H,S>,S extends Steward<H,S>> extends Notion<H,Identity.Ghost,Context.Ethereal,S> {

    protected Ziggurat Ziggurat;

    public House(Identity.Ghost ghost) {
        super(ghost);
    }

}
