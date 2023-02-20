package dev.inward.matrix.fact.authoritative.yard;

import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.authoritative.notion.Industry;
import dev.inward.matrix.fact.Context;
import dev.inward.matrix.resources.Storage;

public class Hospitality extends Industry<Hospitality, Tree, Soul,Identity.SuperEgo, Context.Path,Skeleton,Spirit> {

    public Hospitality(Storage<Hospitality, Tree, Soul, Identity.SuperEgo, Context.Path, Skeleton, Spirit, Identity.SuperEgo, Context.Path> storage) {
        super(storage);
    }
}
