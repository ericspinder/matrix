package dev.inward.gathering;

import dev.inward.fact.Fact;
import dev.inward.fact.Model;

import java.util.List;

public abstract class Gathering<T extends Synth<F>, V, O extends Cargo<T, V>, L extends Lexicon<F>, F extends Fact> extends Fact {


    public abstract List<F> getAll();

    public abstract <M extends Model<F, L, T>> List<F> get(M model);
}
