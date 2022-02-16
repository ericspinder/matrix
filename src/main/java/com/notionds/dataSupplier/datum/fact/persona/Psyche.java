package com.notionds.dataSupplier.datum.fact.persona;

import com.notionds.dataSupplier.advisor.Advisor;
import com.notionds.dataSupplier.datum.Id;
import com.notionds.dataSupplier.house.House;
import com.notionds.dataSupplier.library.Library;

public class Psyche<H extends House<H>,L extends Library<L,?>,Y extends Psyche<H,L,Y,FEST>,FEST extends Manifestation<H,L,Y,FEST>> extends Advisor<Persona<H,L,Y,FEST>,Heart<H,L,Y,FEST>,Body<H,L,Y,FEST>, Id.SuperEgo<H>,Psyche<H,L,Y,FEST>> {

    @Override
    public int compareTo(Psyche<H,L,Y,FEST> o) {
        return 0;
    }
}
