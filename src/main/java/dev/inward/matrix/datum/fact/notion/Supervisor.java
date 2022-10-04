package dev.inward.matrix.datum.fact.notion;

import dev.inward.matrix.advisor.Manager;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Context;

public abstract class Supervisor<Y extends Industry<Y,N,S,I,X,O,A>,N extends Notion<N,I,X,A>,S extends Aspect<Y,N,S,I,X,O,A>,I extends Identity<I,X>,X extends Context<X>,O extends Omnibus<Y,N,S,I,X,O,A>,A extends Agent<N,I,X,A>,U extends Supervisor<Y,N,S,I,X,O,A,U>> extends Manager<Y,N,S,I,X,O,A,I,X,U> {


}
