package dev.inward.matrix.datum.fact.notion.room;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.Ambassador;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.corpus.Corpus;
import dev.inward.matrix.datum.fact.notion.concept.corpus.Prophet;

import java.lang.ref.ReferenceQueue;
import java.math.BigInteger;

public class HouseKeeping extends Ambassador<Hotel,Room,Desk, Identity.Ego<Context.Service>,Context.Service,Cart,HouseKeeping, Corpus, Prophet> {
    public HouseKeeping(Room fact, ReferenceQueue<Room> referenceQueue, Cart omnibus, Desk aspect, Prophet mortal, BigInteger initialSize) {
        super(fact, referenceQueue, omnibus, aspect, mortal, initialSize);
    }
}
