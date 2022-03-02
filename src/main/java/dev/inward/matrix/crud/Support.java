package dev.inward.matrix.crud;

import com.notionds.dataSupplier.container.Context;
import com.notionds.dataSupplier.datum.Id;
import com.notionds.dataSupplier.datum.fact.Bus;
import com.notionds.dataSupplier.datum.fact.Fact;
import com.notionds.dataSupplier.operational.Operational;
import com.notionds.dataSupplier.provider.Parent;

public abstract class Support<F extends Fact<F,S,I,X>, O extends Operational<F,O,S,I,X,B>,S extends Support<F,O,S,I,X,B,A,FP,OP,SP,IP,XP,BP,AP>,I extends Id<I,X>,X extends Context<X>,B extends Bus<F,S,I,X,B>,A extends Parent<F,O,S,I,X,B,A,FP,OP,SP,IP,XP,BP,AP>,
        FP extends Fact<FP,SP,IP,XP>,OP extends Operational<FP,OP,SP,IP,XP,BP>,SP extends Support<FP,OP,SP,IP,XP,BP,?,?,?,?,?,?,?,?>,IP extends Id<IP,XP>,XP extends Context<XP>,BP extends Bus<FP,SP,IP,XP,BP>,AP extends Parent<FP,OP,SP,IP,XP,BP,A,?,?,?,?,?,?,AP>> extends Container<F,S,FP,OP,SP,IP,XP,BP,A> {


    
}
