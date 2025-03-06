/*
 * * Pinder's Matrix © 2025 by Eric S Pinder is licensed under Creative Commons
 *  Attribution-NonCommercial-NoDerivatives 4.0 International. To view a copy of this
 *  license, visit https://creativecommons.org/licenses/by-nc-nd/4.0/
 * /
 */

package crud;

import dev.inward.matrix.datum.fact.notion.Path;
import dev.inward.matrix.datum.Id;
import dev.inward.matrix.datum.fact.Bus;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.operational.Operational;
import dev.inward.matrix.datum.fact.Progenitor;

public abstract class Support<F extends Fact<F,S,I,X>, O extends Operational<F,O,S,I,X,B>,S extends Support<F,O,S,I,X,B,A,FP,OP,SP,IP,XP,BP,AP>,I extends Id<I,X>,X extends Context<X>,B extends Bus<F,S,I,X,B>,A extends Progenitor<F,O,S,I,X,B,A,FP,OP,SP,IP,XP,BP,AP>,
        FP extends Fact<FP,SP,IP,XP>,OP extends Operational<FP,OP,SP,IP,XP,BP>,SP extends Support<FP,OP,SP,IP,XP,BP,?,?,?,?,?,?,?,?>,IP extends Id<IP,XP>,XP extends Path<XP>,BP extends Bus<FP,SP,IP,XP,BP>,AP extends Progenitor<FP,OP,SP,IP,XP,BP,A,?,?,?,?,?,?,AP>> extends Container<F,S,FP,OP,SP,IP,XP,BP,A> {


    
}
