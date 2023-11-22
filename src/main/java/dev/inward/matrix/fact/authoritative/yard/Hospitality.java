package dev.inward.matrix.fact.authoritative.yard;

import dev.inward.matrix.Identity;
import dev.inward.matrix.fact.authoritative.notion.Industry;
import dev.inward.matrix.Context;
import dev.inward.matrix.resources.Storage;

public class Hospitality extends Industry<Hospitality, Tree, Soul, Identity.Gate, Context.Path,Skeleton,Spirit> {

    public Hospitality(Storage<Hospitality, Tree, Soul, Identity.Gate, Context.Path, Skeleton, Spirit, Identity.Gate, Context.Path> storage) {
        super(storage);
    }
}
