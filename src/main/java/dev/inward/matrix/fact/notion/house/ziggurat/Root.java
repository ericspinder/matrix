package dev.inward.matrix.fact.notion.house.ziggurat;

import dev.inward.matrix.fact.notion.house.Steward;
import dev.inward.matrix.resources.NotionProtectionDomain;

import java.lang.ref.ReferenceQueue;

public class Root extends Steward<Ziggurat,Root> {

    public Root(Ziggurat ziggurat, ReferenceQueue<Ziggurat> referenceQueue, NotionProtectionDomain notionProtectionDomain) {
        super(ziggurat, referenceQueue, notionProtectionDomain);
    }
}
