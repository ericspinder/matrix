package dev.inward.matrix.fact.authoritative.notion;

import dev.inward.matrix.Scheme;
import dev.inward.matrix.Library;
import dev.inward.matrix.fact.Addressed;
import dev.inward.matrix.fact.Concept;
import dev.inward.matrix.Identity;
import dev.inward.matrix.fact.authoritative.notion.concept.Construct;
import dev.inward.matrix.fact.authoritative.notion.concept.Matrix;
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

public abstract class Notion<S extends Scheme<S,L>,L extends Library<S,L>> extends Concept<S,L, Path,UUID, Identity.Tangible.Gate<S,L>,Notion<S,L>> {

    protected Map<Personality, Personas>

    public Notion(Identity.Tangible.Gate<S,L> id) {
        super(id);
    }


}
