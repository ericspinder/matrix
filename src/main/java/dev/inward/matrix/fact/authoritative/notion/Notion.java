package dev.inward.matrix.fact.authoritative.notion;

import dev.inward.matrix.Profile;
import dev.inward.matrix.Scheme;
import dev.inward.matrix.Library;
import dev.inward.matrix.fact.Addressed;
import dev.inward.matrix.fact.Concept;
import dev.inward.matrix.Identity;
import dev.inward.matrix.fact.authoritative.notion.concept.Construct;
import dev.inward.matrix.fact.authoritative.notion.concept.Matrix;
import dev.inward.matrix.fact.datum.User;
import dev.inward.matrix.personality.Personality;
import dev.inward.matrix.personality.Personas;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.util.Map;
import java.util.UUID;

public abstract class Notion<S extends Scheme<S,L>,L extends Library<S,L>,P extends Profile<S,L,P,U>,U extends User<S,L,U>> extends Concept<S,L,P,UUID, Identity.Tangible.Gate<S,L,P,U>,Notion<S,L,P,U>> {

    protected Map<Personality, Personas>

    public Notion(Identity.Tangible.Gate<S,L> id) {
        super(id);
    }


}
