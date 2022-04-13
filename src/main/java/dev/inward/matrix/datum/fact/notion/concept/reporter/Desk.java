package dev.inward.matrix.datum.fact.notion.concept.reporter;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.Aspect;
import dev.inward.matrix.path.Path;


public class Desk<P extends Press<P,E,R,X,J,T>,E extends Reporter<E,X,T>,R extends Desk<P,E,R,X,J,T>,X extends Path<X>,J extends Journal<E,J>,T extends Editor<P,E,R,X,J,T>> extends Aspect<P,E,R, Identity.Id<X>,X,J,T> {


}
