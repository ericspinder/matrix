package dev.inward.matrix.model;

import dev.inward.matrix.fact.Fact;
import dev.inward.matrix.gathering.Lexicon;
import dev.inward.matrix.gathering.Synth;

import java.util.List;

public class Model<F extends Fact<F>, L extends Lexicon<F>> {

    private L lexicon;

    private List<Synth> synths;

}