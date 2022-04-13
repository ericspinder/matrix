package crud;

import dev.inward.matrix.datum.fact.notion.Path;
import dev.inward.matrix.datum.Datum;
import dev.inward.matrix.datum.Id;
import dev.inward.matrix.datum.fact.Bus;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.operational.Operational;
import dev.inward.matrix.datum.fact.Progenitor;

import java.io.Serializable;

public abstract class Container<D extends Datum<D,C>,C extends Container<D,C,FP,OP,SP,IP,XP,BP,A>,FP extends Fact<FP,SP,IP,XP>,OP extends Operational<FP,OP,SP,IP,XP,BP>,SP extends Support<FP,OP,SP,IP,XP,BP,A,?,?,?,?,?,?,?>,IP extends Id<IP,XP>,XP extends Path<XP>,BP extends Bus<FP,SP,IP,XP,BP>,A extends Progenitor<FP,OP,SP,IP,XP,BP,A,?,?,?,?,?,?,?>> implements Comparable<C>, Serializable {



}
