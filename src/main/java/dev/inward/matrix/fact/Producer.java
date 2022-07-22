package dev.inward.matrix.fact;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.fact.notion.Ambassador;
import dev.inward.matrix.fact.notion.Notion;
import dev.inward.matrix.fact.notion.concept.Context;
import dev.inward.matrix.operational.Operational;

import java.util.LinkedHashMap;

public class Producer<Y extends Factory<Y,F,O,I,X,B,P,N,A>,F extends Fact<F,I,X,P>,O extends Operational<Y,F,O,I,X,B,P,N,A>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<Y,F,O,I,X,B,P,N,A>,P extends Diplomat<Y,F,O,I,X,B,P,N,A>,N extends Notion<N,I,X,A>,A extends Ambassador<?,N,?,I,X,?,A,?,?>>  extends LinkedHashMap<Class<?>, Resource<Y,?,?,?,F,O,I,X,B,P>> {



}
