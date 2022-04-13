package dev.inward.matrix.datum.fact.notion.concept.reporter;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Progenitor;
import dev.inward.matrix.datum.fact.notion.Industry;
import dev.inward.matrix.path.Path;
import dev.inward.matrix.rubric.Predictor;

import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingDeque;

public class Press<P extends Press<P,E,R,X,J,ET>,E extends Reporter<E,X,ET>,R extends Desk<P,E,R,X,J,ET>,X extends Path<X>,J extends Journal<E,J>,ET extends Editor<P,E,R,X,J,ET>> extends Industry<P,E,R, Identity.Id<X>,X,J,ET> {

    public Press(Progenitor progenitor, LinkedBlockingDeque<R> operationalDeque, Map<Class<?>, List<Predictor<P, ?, E, R, Identity.Id<X>, X, J, ET, ?, ?, ?>>> predictorMap) {
        super(progenitor, operationalDeque, predictorMap);
    }

    @Override
    public int compareTo(P o) {
        return 0;
    }
}
