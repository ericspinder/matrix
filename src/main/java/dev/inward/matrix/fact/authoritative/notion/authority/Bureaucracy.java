package dev.inward.matrix.fact.authoritative.notion.authority;

import dev.inward.matrix.Host;
import dev.inward.matrix.fact.authoritative.notion.Industry;
import dev.inward.matrix.Context;
import dev.inward.matrix.resources.Storage;

public class Bureaucracy extends Industry<Bureaucracy, Host,Identity.Ghost, Context.Ethereal,Docket,Judge> {

    public Bureaucracy(Storage<Bureaucracy, Host, Court, Identity.Gate, Context.Path, Docket, Judge> storage) {
        super(storage);
    }
}
