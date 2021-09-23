package dev.inward.gathering;

import dev.inward.fact.Fact;
import dev.inward.model.Model;

import java.util.List;

public abstract class Gathering<K, V, O extends Cargo<K, V>, L extends Lexicon<F>, F extends Fact> {

    public abstract List<F> getAll();

    public abstract <M extends Model<F, L, T>> List<F> get(M model);
}
