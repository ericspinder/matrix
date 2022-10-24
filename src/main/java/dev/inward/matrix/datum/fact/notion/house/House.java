package dev.inward.matrix.datum.fact.notion.house;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.Notion;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.domain.Authority;
import dev.inward.matrix.engine.Zone;
import dev.inward.matrix.resources.OSinfo;

public class House<H extends House<H,P>,P extends Prophet<H,P>> extends Notion<H,Identity.Ghost,Context.Ethereal, P> {

    public static final House aforementioned = new House();

    protected dev.inward.matrix.datum.fact.notion.house.ziggurat.Ziggurat Ziggurat;

    public House() {
    }

    public OSinfo OSinfo() {
        return oSinfo;
    }

    public Authority findAuthority(Domain domain, Zone zone) {
        if (domain == null) {
            LocalAuthority localAuthority =
        }
        return null;
    }
    public Identity.Ghost identity() {
        return this.ghost;
    }
}
