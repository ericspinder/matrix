package dev.inward.matrix.fact.setting;


import dev.inward.matrix.fact.authoritative.Identity;
import dev.inward.matrix.fact.Context;

public class MagicWord extends Setting<MagicWord, Identity.WebPage, Context.Path> {

    protected final String magicWord;

    public MagicWord(Identity.WebPage webPage, String magicWord) {
        super(webPage);
        this.magicWord = magicWord;
    }

    public String getMagicWord() {
        return this.magicWord;
    }

}
