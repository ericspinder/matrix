package dev.inward.matrix.datum.fact.notion.reporter;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.Ambassador;
import dev.inward.matrix.datum.fact.notion.concept.Concept;
import dev.inward.matrix.datum.fact.notion.concept.Mortal;
import dev.inward.matrix.path.Path;

import java.lang.ref.ReferenceQueue;
import java.math.BigInteger;

public class Editor<P extends Press<P,R,K,X,J,ED,C,M>,R extends Reporter<R,X,ED>,K extends Desk<P,R,K,X,J,ED,C,M>,X extends Path<X>,J extends Journal<P,R,K,X,J,ED,C,M>,ED extends Editor<P,R,K,X,J,ED,C,M>,C extends Concept<C,?,M>,M extends Mortal<?,C,?,?,?,M>> extends Ambassador<P,R,K,Identity.Id<X>,X,J,ED,C,M> {
    public Editor(R reporter, ReferenceQueue<R> referenceQueue, J bus, K operational, M mortal, BigInteger initialSize) {
        super(reporter, referenceQueue,bus,operational,mortal,initialSize);
    }
}
