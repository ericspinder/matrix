package com.notionds.dataSupplier.house;

import com.notionds.dataSupplier.Unspoken;
import com.notionds.dataSupplier.container.Context;
import com.notionds.dataSupplier.datum.Id;
import com.notionds.dataSupplier.library.Library;

public class Ego<H extends House<H,L>,L extends Library<H,L>,I extends Ego<H,L,I,X>,X extends Context<H,L,X>> extends Id<H,L,I,X> {


    protected final H house;
    @Unspoken
    protected final String magicWord;

    public Ego(String id, X context, H house, String magicWord) {
        super(id, context);
        this.house = house;
        this.magicWord = magicWord;
    }

    @Override
    public int compareTo(I that) {
        int isZero = super.compareTo(that);
        if (isZero == 0 && !this.magicWord.equals(that.magicWord)) {
            return this.magicWord.compareTo(that.magicWord);
        }
        return isZero;
    }
    public H getHouse() {
        return this.house;
    }
    public String getMagicWord() {
        return this.magicWord;
    }
}
