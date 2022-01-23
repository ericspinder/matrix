package com.notionds.dataSupplier.datum.fact.persona;

import com.notionds.dataSupplier.container.Context;
import com.notionds.dataSupplier.house.Ego;
import com.notionds.dataSupplier.house.House;

public final class SuperEgo<H extends House<H,?>> extends Ego<H,SuperEgo<H>,Context.Individual<H>> {


    public SuperEgo(String name, H house, String magicWord) {
        super(name,new Context.Individual(house), house, magicWord);
    }
}
