package dev.inward.matrix.clues;


public class TestName extends Clue<String> {

    public TestName(String s) {
        super(s);
    }

    @Override
    protected String initDefault() {
        return "";
    }
}
