package dev.inward.matrix.datum.fact.notion.concept.boot;

import dev.inward.matrix.datum.fact.notion.concept.Volume;
import dev.inward.matrix.datum.fact.notion.house.ziggurat.Boot;
import dev.inward.matrix.datum.fact.notion.house.ziggurat.Init;
import dev.inward.matrix.datum.fact.notion.house.ziggurat.Root;
import dev.inward.matrix.datum.fact.notion.house.ziggurat.Ziggurat;

public class Structure extends Volume<Boot, Ziggurat, Init,Structure, Root> {

    public Structure(Init operational) {
        super(operational);
    }
}
