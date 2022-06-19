package dev.inward.matrix.datum.fact.notion.reporter;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Resource;
import dev.inward.matrix.datum.fact.notion.Industry;
import dev.inward.matrix.datum.fact.notion.concept.Concept;
import dev.inward.matrix.datum.fact.notion.concept.Mortal;
import dev.inward.matrix.path.Path;

import java.util.Map;

public class Press<P extends Press<P,R,K,X,J,ED,C,M>, R extends Reporter<R,X,ED>,K extends Desk<P,R,K,X,J,ED,C,M>,X extends Path<X>,J extends Journal<P,R,K,X,J,ED,C,M>,ED extends Editor<P,R,K,X,J,ED,C,M>,C extends Concept<C,?,M>,M extends Mortal<?,C,?,?,?,M>> extends Industry<P,R,K,Identity.Id<X>,X,J,ED,C,M> {

    public Press(ED progenitor, Map<Class<?>, Resource<P,?,?,?,R,K,Identity.Id<X>,X,J,ED,R,ED>> resourcesMap) {
        super(progenitor, resourcesMap);
    }

    @Override
    public int compareTo(P o) {
        return 0;
    }
}
