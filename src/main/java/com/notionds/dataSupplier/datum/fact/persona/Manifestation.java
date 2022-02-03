package com.notionds.dataSupplier.datum.fact.persona;

import com.notionds.dataSupplier.house.House;
import com.notionds.dataSupplier.library.Library;
import com.notionds.dataSupplier.provider.Provider;

public abstract class Manifestation<H extends House<H,L>, L extends Library<H,L>,Y extends Psyche<H,L,Y,FEST>, FEST extends Manifestation<H,L,Y,FEST>> extends Provider<Persona<H,L,Y,FEST>,Heart<H,L,Y,FEST>,Body<H,L,Y,FEST>,SuperEgo<H,L>,Manifestation<H,L,Y,FEST>> {

}
