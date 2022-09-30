package dev.inward.matrix.library;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Bus;
import dev.inward.matrix.datum.fact.Diplomat;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.datum.fact.Factory;
import dev.inward.matrix.datum.fact.notion.concept.*;
import dev.inward.matrix.datum.fact.Operational;

import java.net.Socket;

public class NetworkContact<Y extends Factory<Y,F,O,I,X,B,P,FAB,C,E,V,M>,F extends Fact<F,I,X,P>,O extends Operational<Y,F,O,I,X,B,P>,I extends Identity<I,X>,X extends Context<X>,B extends Bus<Y,F,O,I,X,B,P>,P extends Diplomat<Y,F,O,I,X,B,P>,FAB extends Fabrication<FAB,C,E,V,M>,C extends Concept<C,M>,E extends Effect<FAB,C,E,V,M>,V extends Volume<FAB,C,E,V,M>,M extends Mortal<FAB,C,E,V,M>> {

    protected Map<Socket, socket;
}
