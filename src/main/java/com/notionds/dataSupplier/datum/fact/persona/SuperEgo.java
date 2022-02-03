package com.notionds.dataSupplier.datum.fact.persona;

import com.notionds.dataSupplier.container.Context;
import com.notionds.dataSupplier.house.Ego;
import com.notionds.dataSupplier.house.House;
import com.notionds.dataSupplier.library.Library;

public final class SuperEgo<H extends House<H,L>,L extends Library<H,L>> extends Ego<H,L,SuperEgo<H,L>,Context.Individual<H,L>> {


    public SuperEgo(String name, H house, String magicWord) {
        super(name,new Context.Individual(house), house, magicWord);
    }
}
