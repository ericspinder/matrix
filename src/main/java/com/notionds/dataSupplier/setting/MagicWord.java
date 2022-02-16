package com.notionds.dataSupplier.setting;


import com.notionds.dataSupplier.Unspoken;
import com.notionds.dataSupplier.container.Context;
import com.notionds.dataSupplier.datum.Id;
import com.notionds.dataSupplier.house.House;
import com.notionds.dataSupplier.library.Library;

public class MagicWord<H extends House<H,L>,L extends Library<H,L>,I extends Id.Ego<H,L,I,X>,X extends Context<H,L,X>, S extends Setting<H,L,I,X,S>> extends Setting<H,L,I,X,S> {

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
