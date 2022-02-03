package com.notionds.dataSupplier.datum.fact.persona;

import com.notionds.dataSupplier.datum.fact.notion.Aspect;
import com.notionds.dataSupplier.house.House;
import com.notionds.dataSupplier.library.Library;
import dev.inward.matrix.gathering.Lexicon;
import dev.inward.matrix.setting.Gate;

public class Body<H extends House<H,L>,L extends Library<H,L>,Y extends Psyche<H,L,Y,FEST>,FEST extends Manifestation<H,L,Y,FEST>> extends Aspect<Persona<H,L,Y,FEST>, Heart<H,L,Y,FEST>, Body<H,L,Y,FEST>,SuperEgo<H,L>, Skeleton<H,L,Y,FEST>> {

    public Body(Skeleton<H,L,Y,FEST> skeleton, Gate gate, Lexicon lexicon) {
        super(skeleton, gate, lexicon);
    }
}
