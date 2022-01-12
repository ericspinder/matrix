package com.notionds.dataSupplier.house;

import com.notionds.dataSupplier.Unspoken;
import com.notionds.dataSupplier.context.Context;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.datum.notion.fact.Id;

public class Ego<D extends Datum<D,?,?,I>, I extends Ego<D,I>> extends Id<D,I> {

    @Unspoken
    protected String magicWord;

    public Ego(String id, Context<D> context, String magicWord) {
        super(id, context);
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
}
