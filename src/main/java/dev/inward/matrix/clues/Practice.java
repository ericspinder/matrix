package dev.inward.matrix.clues;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.operational.Operational;

public abstract class Practice<BEHAVIOR,O extends Operational<?,?,?,CI,CX,?,?,?,?>,CI extends Identity<CI, CX>, CX extends Context<CX>, P extends Policy<BEHAVIOR,O, CI, CX,P>> extends Policy<BEHAVIOR,O, CI, CX,P> {

    public Practice(Operational operational, CI id) {
        super(operational, id);
    }

    public Practice(BEHAVIOR BEHAVIOR) {
        super(BEHAVIOR);
    }
}
