package crud.model;

import dev.inward.crud.gathering.Lexicon;
import dev.inward.crud.gathering.Synth;
import dev.inward.matrix.datum.fact.notion.Notion;

import java.util.List;

public class Model<F extends Notion<F>, L extends Lexicon<F>> {

    private L lexicon;

    private List<Synth> synths;

}