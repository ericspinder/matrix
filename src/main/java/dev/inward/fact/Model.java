package dev.inward.fact;

import dev.inward.morph.CreationMorph;
import dev.inward.gathering.Lexicon;
import dev.inward.gathering.Synth;

public class Model<F extends Fact, A extends Lexicon<F>, T extends Synth> extends Fact {

    public Model(A agenda, CreationMorph creationMorph) {
        super(creationMorph);
    }

}
