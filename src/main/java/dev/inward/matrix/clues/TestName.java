package dev.inward.matrix.clues;


public class TestName extends Policy<String> {

    public TestName(String s) {
        super(s);
    }

    @Override
    protected String initDefault() {
        return "";
    }
}
