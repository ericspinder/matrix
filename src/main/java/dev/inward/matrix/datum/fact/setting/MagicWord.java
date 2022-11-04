package dev.inward.matrix.datum.fact.setting;


import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.datum.fact.notion.concept.Context;

public class MagicWord extends Setting<MagicWord, Identity.Id,Context.Service> {

    protected final String magicWord;

    public MagicWord(Identity.Id id, String magicWord) {
        super(id);
        this.magicWord = magicWord;
    }

    public String getMagicWord() {
        return this.magicWord;
    }

}
