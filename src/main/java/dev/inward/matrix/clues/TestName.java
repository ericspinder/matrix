package dev.inward.matrix.clues;


import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.Notion;
import dev.inward.matrix.datum.fact.notion.concept.Context;

public class TestName<N extends Notion<N,I,X>,I extends Identity.Id<X>,X extends Context<X>> extends Practice<String,> {

    public TestName(String s) {
        super(s);
    }

    @Override
    protected String initDefault() {
        return "";
    }
}
