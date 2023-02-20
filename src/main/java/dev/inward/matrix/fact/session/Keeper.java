package dev.inward.matrix.fact.session;

import dev.inward.matrix.fact.Operational;
import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.Context;

public class Keeper extends Operational<SessionFactory,Session,Keeper, Identity.Ego<Context.Path>, Context.Path,Huddle,Guest> {
}
