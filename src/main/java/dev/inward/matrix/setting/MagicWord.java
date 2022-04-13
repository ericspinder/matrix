package dev.inward.matrix.setting;


import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.notion.concept.dataSupplier.Unspoken;
import dev.inward.matrix.datum.Identity;
import dev.inward.matrix.house.House;
import dev.inward.matrix.datum.fact.Factory;

public class MagicWord<H extends House<H,?,?>,L extends Factory<L>,I extends Identity.Id<L>,S extends MagicWord<H,L,I,S>> extends Setting<L,I, Context<L>,S> {

    @Unspoken
    private String magicWord;

    public MagicWord(I id, String magicWord) {
        super(id);
        this.magicWord = magicWord;
    }

    public String getMagicWord() {
        return this.magicWord;
    }

}
