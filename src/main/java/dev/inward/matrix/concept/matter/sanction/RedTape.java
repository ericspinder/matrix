package dev.inward.matrix.concept.matter.sanction;

import dev.inward.matrix.fact.Bus;
import dev.inward.matrix.Identity;
import dev.inward.matrix.fact.authoritative.Regulated;
import dev.inward.matrix.fact.authoritative.Regulator;
import dev.inward.matrix.Context;

public class RedTape<ID extends Identity.Web<ID,P>,P extends Context.Platform<P>> extends Bus<Regulator<ID,P>, Identity.Gate, Context.Path,RedTape<ID,P>, Regulated<ID,P>,ID,P> {


}
