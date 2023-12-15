package dev.inward.matrix.fact.authoritative.notion.concept.evaluate;

import crud.Volume;

public class Calc extends Volume<Bakery,Evaluate,Batch,Calc,Existent> {

    public Calc(Batch operational) {
        super(operational);
    }

}
