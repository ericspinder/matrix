package dev.inward.matrix.fact.authoritative.notion.authority;

import dev.inward.matrix.authority.Authority;
import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.authoritative.notion.Industry;
import dev.inward.matrix.fact.Context;
import dev.inward.matrix.resources.Storage;

public class Bureaucracy extends Industry<Bureaucracy, Authority,Identity.Ghost, Context.Ethereal,Docket,Judge> {

    public Bureaucracy(Storage<Bureaucracy, Authority, Court, Identity.SuperEgo, Context.Path, Docket, Judge> storage) {
        super(storage);
    }
}
