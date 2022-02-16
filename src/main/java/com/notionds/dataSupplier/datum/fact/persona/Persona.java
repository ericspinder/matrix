package com.notionds.dataSupplier.datum.fact.persona;

import com.notionds.dataSupplier.datum.Id;
import com.notionds.dataSupplier.datum.fact.notion.Notion;
import com.notionds.dataSupplier.house.House;
import com.notionds.dataSupplier.library.Library;

public final class Persona<H extends House<H>,L extends Library<L>,Y extends Psyche<H,L,Y,FEST>,FEST extends Manifestation<H,L,Y,FEST>> extends Notion<Persona<H,L,Y,FEST>, Heart<H,L,Y,FEST>, Body<H,L,Y,FEST>, Id.SuperEgo<H>> {


    public Persona(Id.SuperEgo<H> id, Body<H,L,Y,FEST> container) {
        super(id, container);
    }

}
