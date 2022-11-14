package dev.inward.matrix.policy;


import dev.inward.matrix.fact.datum.Identity;
import dev.inward.matrix.fact.notion.Notion;
import dev.inward.matrix.fact.notion.concept.Context;

public class TestName<N extends Notion<N,I,X>,I extends Identity.Id<X>,X extends Context<X>> extends Practice<String,> {

    public TestName(String s) {
        super(s);
    }

    @Override
    protected String initDefault() {
        return "";
    }
}
