package dev.inward.matrix.fact.notion.authority;

import dev.inward.matrix.fact.datum.Identity;
import dev.inward.matrix.resources.Storage;
import dev.inward.matrix.fact.notion.Industry;
import dev.inward.matrix.fact.notion.concept.Context;

public class Bureaucracy extends Industry<Bureaucracy,Authority,Identity.Ghost,Context.Ethereal,Docket,Judge> {

    public Bureaucracy(Storage<Bureaucracy, Authority, Court, Identity.SuperEgo, Context.Service, Docket, Judge> storage) {
        super(storage);
    }
}
