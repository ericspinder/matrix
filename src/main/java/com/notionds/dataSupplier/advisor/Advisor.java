package com.notionds.dataSupplier.advisor;

import com.notionds.dataSupplier.container.Container;
import com.notionds.dataSupplier.Factory;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.datum.Id;
import com.notionds.dataSupplier.operational.Operational;

import java.io.Serializable;


public abstract class Advisor<D extends Datum<?,D,O,C,I>,O extends Operational<D,O>, C extends Container<D,O,C,I>,I extends Id<?,?,I,?>,A extends Advisor<D,O,C,I,A>> implements Comparable<A>, Serializable {

//
//    default handle(T t, D datum, S sanction, Matter.Focus focus, Matter.Locus locus) {
//        return new Throwable(t.getMessage(),sanction, focus, locus, t);
//    }


}