package com.notionds.dataSupplier.container;

import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.datum.Id;
import com.notionds.dataSupplier.datum.fact.Fact;
import com.notionds.dataSupplier.datum.fact.Support;
import com.notionds.dataSupplier.rubric.Criterion;
import com.notionds.dataSupplier.subject.Breaker;
import com.notionds.dataSupplier.subject.Broken;
import com.notionds.dataSupplier.operational.Operational;
import com.notionds.dataSupplier.provider.Envoy;
import com.sun.jdi.VirtualMachine;
import com.sun.jdi.request.EventRequest;

import java.util.*;
import java.util.concurrent.locks.StampedLock;

public final class Situation<D extends Datum<?,D,C>,C extends Container<D,C>,F extends Fact<F,O,S,I,X,?>,O extends Operational<F,O>,S extends Support<F,O,S,I,X,?>,I extends Id<I,X>,X extends Context<X>> {


}
