package dev.inward.matrix.fact.authoritative.notion.concept.boot;

import dev.inward.matrix.fact.authoritative.notion.concept.Volume;
import dev.inward.matrix.fact.authoritative.notion.authority.source.ziggurat.Boot;
import dev.inward.matrix.fact.authoritative.notion.authority.source.ziggurat.Init;
import dev.inward.matrix.fact.authoritative.notion.authority.source.ziggurat.Root;
import dev.inward.matrix.fact.authoritative.notion.authority.source.ziggurat.Ziggurat;

public class Structure extends Volume<Boot, Ziggurat, Init,Structure, Root> {

    public Structure(Init operational) {
        super(operational);
    }
}
