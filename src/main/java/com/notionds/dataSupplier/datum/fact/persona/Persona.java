package com.notionds.dataSupplier.datum.fact.persona;

import com.notionds.dataSupplier.advisor.Advisor;
import com.notionds.dataSupplier.datum.fact.notion.Notion;
import com.notionds.dataSupplier.house.House;
import com.notionds.dataSupplier.library.Library;
import com.notionds.dataSupplier.provider.Provider;

public final class Persona<H extends House<H,L>,L extends Library<H,L>,Y extends Psyche<H,L,Y,FEST>,FEST extends Manifestation<H,L,Y,FEST>> extends Notion<Persona<H,L,Y,FEST>, Heart<H,L,Y,FEST>, Body<H,L,Y,FEST>,SuperEgo<H,L>> {


    public Persona(SuperEgo<H,L> id, Body<H,L,Y,FEST> container) {
        super(id, container);
    }

}
