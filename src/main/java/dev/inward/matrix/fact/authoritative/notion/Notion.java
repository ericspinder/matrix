package dev.inward.matrix.fact.authoritative.notion;

import dev.inward.matrix.Profile;
import dev.inward.matrix.Scheme;
import dev.inward.matrix.Library;
import dev.inward.matrix.fact.Concept;
import dev.inward.matrix.Dogma;
import dev.inward.matrix.personality.Personality;
import dev.inward.matrix.personality.Personas;

import java.util.Map;
import java.util.UUID;

public abstract class Notion<S extends Scheme<S,L>,L extends Library<S,L>,P extends Profile<S,L,P,U>,U extends Dogma<S,L,U>> extends Concept<S,L,P,UUID, Concept.Tangible.Gate<S,L,P,U>,Notion<S,L,P,U>> {

    protected Map<Personality, Personas>

    public Notion(Tangible.Gate<S,L> id) {
        super(id);
    }


}
