package dev.inward.matrix.datum.fact;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.Agent;
import dev.inward.matrix.resources.Resource;
import dev.inward.matrix.datum.fact.notion.Notion;
import dev.inward.matrix.datum.fact.notion.concept.Context;

import java.util.LinkedHashMap;

public class Producer<Y extends Factory<Y,F,O,I,X,B,R,N,A>,F extends Fact<F,I,X,R>,O extends Operational<Y,F,O,I,X,B,R,N,A>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<Y,F,O,I,X,B,R>,R extends Representative<F,I,X,R>,N extends Notion<N,I,X,A>,A extends Agent<N,I,X,A>>  extends LinkedHashMap<Class<?>, Resource<?,?,?,F,I,X,R>> {





}
