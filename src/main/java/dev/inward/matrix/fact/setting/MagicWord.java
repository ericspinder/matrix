package dev.inward.matrix.fact.setting;


import dev.inward.matrix.Context;

public class MagicWord extends Setting<MagicWord, Identity.Web, Context.Path> {

    protected final String magicWord;

    public MagicWord(Identity.Web web, String magicWord) {
        super(web);
        this.magicWord = magicWord;
    }

    public String getMagicWord() {
        return this.magicWord;
    }

}
