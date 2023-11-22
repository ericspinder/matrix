package dev.inward.matrix.policy;


import dev.inward.matrix.Identity;
import dev.inward.matrix.fact.authoritative.notion.Notion;
import dev.inward.matrix.Context;

public class TestName<N extends Notion<N,I,X>,I extends Identity.Web<X>,X extends Context<X>> extends Practice<String,> {

    public TestName(String s) {
        super(s);
    }

    @Override
    protected String initDefault() {
        return "";
    }
}
