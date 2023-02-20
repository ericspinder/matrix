package dev.inward.matrix.fact.authoritative.notion.house;

import dev.inward.matrix.fact.authoritative.Governance;
import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.authoritative.notion.Notion;

public abstract class House<H extends House<H,S>,S extends Steward<H,S>> extends Notion<H,Identity.Ghost, Governance.Ethereal,S> {

    public House(Identity.Ghost ghost) {
        super(ghost);
    }

}
