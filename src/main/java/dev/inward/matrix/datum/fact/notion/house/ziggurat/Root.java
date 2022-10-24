package dev.inward.matrix.datum.fact.notion.house.ziggurat;

import dev.inward.matrix.datum.fact.notion.concept.Mortal;
import dev.inward.matrix.datum.fact.notion.concept.boot.Boot;
import dev.inward.matrix.datum.fact.notion.concept.boot.Init;
import dev.inward.matrix.datum.fact.notion.concept.boot.Structure;
import dev.inward.matrix.datum.fact.notion.house.Prophet;

import java.lang.ref.ReferenceQueue;

public class Root extends Prophet<Ziggurat,Root> {
    public Root(dev.inward.matrix.datum.fact.notion.concept.boot.Boot edition, ReferenceQueue<Boot> referenceQueue, Structure bus, Init operational) {
        super(edition, referenceQueue, bus, operational);
    }
}
