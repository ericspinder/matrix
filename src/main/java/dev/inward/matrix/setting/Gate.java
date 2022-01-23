package dev.inward.matrix.setting;


import com.notionds.dataSupplier.container.Context;
import com.notionds.dataSupplier.datum.fact.Fact;
import com.notionds.dataSupplier.datum.Id;

public abstract class Gate<F extends Fact<F,?,?,E>,E extends Id<F,E,X>,X extends Context<?,?,X>> extends Setting {

    private MagicWord[] magicWords;

    public Gate(MagicWord[] magicWords) {
        this.magicWords = magicWords;
    }


}
