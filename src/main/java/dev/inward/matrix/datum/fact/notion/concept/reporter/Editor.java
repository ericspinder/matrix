package dev.inward.matrix.datum.fact.notion.concept.reporter;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.Primogenitor;
import dev.inward.matrix.path.Path;

import java.lang.ref.ReferenceQueue;

public class Editor<P extends Press<P,E,R,X,J,T>,E extends Reporter<E,X,T>,R extends Desk<P,E,R,X,J,T>,X extends Path<X>,J extends Journal<E,J>,T extends Editor<P,E,R,X,J,T>> extends Primogenitor<P,E,R, Identity.Id<X>,X,J,T> {
    public Editor(E edition, ReferenceQueue<E> referenceQueue, J bus, R operational) {
        super(edition, referenceQueue, bus, operational);
    }
}
