package com.notionds.dataSupplier.datum.fact.persona;

import com.notionds.dataSupplier.datum.fact.notion.Omnibus;
import com.notionds.dataSupplier.house.House;
import com.notionds.dataSupplier.library.Library;

public final class Skeleton<H extends House<H,L>,L extends Library<H,L>,Y extends Psyche<H,L,Y,FEST>,FEST extends Manifestation<H,L,Y,FEST>> extends Omnibus<Persona<H,L,Y,FEST>, Heart<H,L,Y,FEST>, Body<H,L,Y,FEST>,SuperEgo<H,L>, Skeleton<H,L,Y,FEST>,Psyche<H,L,Y,FEST>,Manifestation<H,L,Y,FEST>, PsycheMeta<H,L,Y,FEST>> {

    public Skeleton(PsycheMeta<H,L,Y,FEST> meta,Heart<H,L,Y,FEST> heart, Psyche<H,L,Y,FEST> psyche, Manifestation<H,L,Y,FEST> manifestation) {
        super(meta,heart,psyche,manifestation);
    }
}
