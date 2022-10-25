package dev.inward.matrix.datum.fact.notion.house.ziggurat;

import dev.inward.matrix.datum.fact.notion.concept.boot.Boot;
import dev.inward.matrix.datum.fact.notion.concept.boot.Structure;
import dev.inward.matrix.datum.fact.notion.house.Steward;

import java.lang.ref.ReferenceQueue;

public class Root extends Steward<Ziggurat,Root> {
    public Root(dev.inward.matrix.datum.fact.notion.concept.boot.Boot edition, ReferenceQueue<Boot> referenceQueue, Structure bus, Init operational) {
        super(edition, referenceQueue, bus, operational);
    }
}
