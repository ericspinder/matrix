package dev.inward.matrix.fact.notion.concept.boot;

import dev.inward.matrix.fact.notion.concept.Mortal;

import java.lang.ref.ReferenceQueue;

public class Root extends Mortal<BootLoader,Boot,Init,Structure,Root> {
    public Root(Boot edition, ReferenceQueue<Boot> referenceQueue, Structure bus, Init operational) {
        super(edition, referenceQueue, bus, operational);
    }
}
