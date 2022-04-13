package dev.inward.matrix.datum.fact.notion.concept.boot;

import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.Immortal;

import java.lang.ref.ReferenceQueue;

public class Root extends Immortal<BootLoader,Boot,Init,Context.JVM,Structure,Root> {
    public Root(Boot edition, ReferenceQueue<Boot> referenceQueue, Structure bus, Init operational) {
        super(edition, referenceQueue, bus, operational);
    }
}
