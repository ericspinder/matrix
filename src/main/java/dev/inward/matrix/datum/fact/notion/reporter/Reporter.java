package dev.inward.matrix.datum.fact.notion.reporter;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.Notion;
import dev.inward.matrix.path.Path;

public abstract class Reporter<R extends Reporter<R,X,ET>,X extends Path<X>,ET extends Editor<?,R,?,X,?,ET,?,?>> extends Notion<R, Identity.Id<X>,X,ET> {


    public Reporter(Identity.Id<X> id) {
        super(id);
    }

//
//    public Meta getMeta(Datum datum) {
//        metas.getOrDefault(datum.getClass().getCanonicalName());
//    }
}
