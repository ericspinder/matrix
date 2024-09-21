package dev.inward.matrix.resources;

import dev.inward.matrix.fact.*;
import dev.inward.matrix.fact.authoritative.notion.Agent;
import dev.inward.matrix.Notion;
import dev.inward.matrix.Context;

public class Pooled<Y extends Factory<Y,F,O,I,X,B,R,N,NI,NX,A>,F extends Fact<F,I,X,R,NI,NX>,O extends Operational<Y,F,O,I,X,B,R,N,NI,NX,A>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<Y,F,O,I,X,B,R>,R extends Rider<F,I,X,R,NI,NX>,N extends Notion<N,NI,NX,A>,NI extends Identity<NI,NX>,NX extends Context<NX>,A extends Agent<N,NI,NX,A>> extends Supplier {

}
