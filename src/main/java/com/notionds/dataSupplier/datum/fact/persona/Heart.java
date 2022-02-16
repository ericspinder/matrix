package com.notionds.dataSupplier.datum.fact.persona;

import com.notionds.dataSupplier.house.House;
import com.notionds.dataSupplier.library.Library;
import com.notionds.dataSupplier.operational.Operational;

import java.time.Duration;

public class Heart<H extends House<H>,L extends Library<L,?>,Y extends Psyche<H,L,Y,FEST>,FEST extends Manifestation<H,L,Y,FEST>> extends Operational<Persona<H,L,Y,FEST>,Heart<H,L,Y,FEST>> {

    public Integer getIntegerPreference(String key) {

    }
    public Boolean getBooleanPreference(String key) {

    }
    public Duration getDurationPreference(String key) {

    }
    public String getStringPreference(String key) {

    }

}
