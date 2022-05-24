package dev.inward.matrix.datum.fact.notion.reporter;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.Omnibus;
import dev.inward.matrix.datum.fact.notion.Supervisor;
import dev.inward.matrix.datum.fact.notion.concept.Concept;
import dev.inward.matrix.datum.fact.notion.concept.Mortal;
import dev.inward.matrix.path.Path;
import dev.inward.matrix.rubric.Criteria;
import dev.inward.matrix.rubric.Criterion;

import java.util.Map;

public class Journal<P extends Press<P,R,K,X,J,ED,C,M>,R extends Reporter<R,X,ED>,K extends Desk<P,R,K,X,J,ED,C,M>,X extends Path<X>,J extends Journal<P,R,K,X,J,ED,C,M>,ED extends Editor<P,R,K,X,J,ED,C,M>,C extends Concept<C,?,M>,M extends Mortal<?,C,?,?,?,M>> extends Omnibus<P,R,K,Identity.Id<X>,X,J,ED,C,M> {
    public Journal(K operational) {
        super(operational);
    }
}
