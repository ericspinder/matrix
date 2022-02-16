package com.notionds.dataSupplier.datum.fact.persona;

import com.notionds.dataSupplier.house.House;
import com.notionds.dataSupplier.library.Library;
import com.notionds.dataSupplier.meta.Meta;

public final class PsycheMeta<H extends House<H>,L extends Library<L,?>,Y extends Psyche<H,L,Y,FEST>,FEST extends Manifestation<H,L,Y,FEST>> extends Meta<Persona<H,L,Y,FEST>, PsycheMeta<H,L,Y,FEST>> {

    public PsycheMeta(String label, String description, String i18n) {
        super(label, description, i18n);
    }

}
