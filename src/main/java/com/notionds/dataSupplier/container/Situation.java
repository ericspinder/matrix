package com.notionds.dataSupplier.container;

import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.datum.Id;
import com.notionds.dataSupplier.datum.fact.Fact;
import dev.inward.matrix.crud.Container;
import dev.inward.matrix.crud.Support;
import com.notionds.dataSupplier.operational.Operational;

public final class Situation<D extends Datum<?,D,C>,C extends Container<D,C>,F extends Fact<F,O,S,I,X,?>,O extends Operational<F,O>,S extends Support<F,O,S,I,X,?>,I extends Id<I,X>,X extends Context<X>> {


}
