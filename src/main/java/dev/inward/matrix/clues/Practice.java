package dev.inward.matrix.clues;

import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.datum.fact.Representative;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.Operational;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public abstract class Practice<BEHAVIOR,F extends Fact<F,I,X,R,CI,CX>,I extends Identity<I,X>,X extends Context<X>,R extends Representative<F,I,X,R,CI,CX>,CF extends Fact<CF,CI,CX,CR,NI,NX>,CO extends Operational<?,CF,CO,CI,CX,?,?,NI,NX>,CI extends Identity<CI,CX>,CX extends Context<CX>,CR extends Representative<CF,CI,CX,CR,NI,NX>,NI extends Identity<NI,NX>,NX extends Context<NX>,P extends Practice<BEHAVIOR,F,I,X,R,CF,CO,CI,CX,CR,NI,NX,P>> extends Policy<BEHAVIOR,F,F,R,CF,CO,CI,CX,CR,P> {

    public Practice(@Nonnull CO operational, @Nonnull CR containingRepresentative, @Nullable CI cid, @Nullable R representative) {
        super(operational, containingRepresentative, cid, representative);
    }

    public Practice(BEHAVIOR BEHAVIOR) {
        super(BEHAVIOR);
    }
}

