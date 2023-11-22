package dev.inward.matrix.fact;

import dev.inward.matrix.Identity;
import dev.inward.matrix.Library;
import dev.inward.matrix.Scheme;
import dev.inward.matrix.fact.authoritative.notion.Notion;
import dev.inward.matrix.fact.datum.Envoy;
import dev.inward.matrix.resources.Resources;

import java.util.UUID;

public class Representative<S extends Scheme<S,L>,L extends Library<S,L>,PATH extends Comparable<PATH>,ID extends Comparable<ID>,T extends Identity.Tangible<S,L,PATH,ID,T,C>,C extends Concept<S,L,PATH,ID,T,C>> extends Envoy<C,Representative<S,L,PATH,ID,T,C>,S,L,PATH,ID,T,C> {

    public Representative(C concept, Resources<S,L,PATH,ID,T,C> referenceQueue) {
        super(concept, referenceQueue);
    }
}
