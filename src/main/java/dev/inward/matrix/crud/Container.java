package dev.inward.matrix.crud;

import com.notionds.dataSupplier.container.Context;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.datum.Id;
import com.notionds.dataSupplier.datum.fact.Bus;
import com.notionds.dataSupplier.datum.fact.Fact;
import com.notionds.dataSupplier.operational.Operational;
import com.notionds.dataSupplier.provider.Parent;

import java.io.Serializable;

public abstract class Container<D extends Datum<D,C>,C extends Container<D,C,FP,OP,SP,IP,XP,BP,A>,FP extends Fact<FP,SP,IP,XP>,OP extends Operational<FP,OP,SP,IP,XP,BP>,SP extends Support<FP,OP,SP,IP,XP,BP,A,?,?,?,?,?,?,?>,IP extends Id<IP,XP>,XP extends Context<XP>,BP extends Bus<FP,SP,IP,XP,BP>,A extends Parent<FP,OP,SP,IP,XP,BP,A,?,?,?,?,?,?,?>> implements Comparable<C>, Serializable {



}
