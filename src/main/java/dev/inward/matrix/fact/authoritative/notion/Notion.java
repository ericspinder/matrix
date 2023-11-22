package dev.inward.matrix.fact.authoritative.notion;

import dev.inward.matrix.Scheme;
import dev.inward.matrix.Library;
import dev.inward.matrix.fact.Addressed;
import dev.inward.matrix.fact.Concept;
import dev.inward.matrix.Identity;
import dev.inward.matrix.fact.authoritative.notion.concept.Construct;
import dev.inward.matrix.fact.authoritative.notion.concept.Matrix;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.util.UUID;

public abstract class Notion<S extends Scheme<S,L>,L extends Library<S,L>> extends Concept<S,L, Path,UUID, Identity.Tangible.Gate<S,L>,Notion<S,L>> implements BasicFileAttributeView {

    public Notion(Identity.Tangible.Gate<S,L> id) {
        super(id);
    }


    @Override
    public String name() {
        return null;
    }

    @Override
    public BasicFileAttributes readAttributes() throws IOException {
        return null;
    }

    @Override
    public void setTimes(FileTime lastModifiedTime, FileTime lastAccessTime, FileTime createTime) throws IOException {

    }
}
