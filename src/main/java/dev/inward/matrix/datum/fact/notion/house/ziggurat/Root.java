package dev.inward.matrix.datum.fact.notion.house.ziggurat;

import dev.inward.matrix.datum.fact.notion.concept.boot.Boot;
import dev.inward.matrix.datum.fact.notion.concept.boot.Structure;
import dev.inward.matrix.datum.fact.notion.house.Steward;
import dev.inward.matrix.resources.NotionProtectionDomain;

import java.lang.ref.ReferenceQueue;

public class Root extends Steward<Ziggurat,Root> {

    public Root(Ziggurat ziggurat, ReferenceQueue<Ziggurat> referenceQueue, NotionProtectionDomain notionProtectionDomain) {
        super(ziggurat, referenceQueue, notionProtectionDomain);
    }
}
