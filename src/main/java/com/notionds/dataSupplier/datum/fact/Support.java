package com.notionds.dataSupplier.datum.fact;

import com.notionds.dataSupplier.container.Container;
import com.notionds.dataSupplier.Unspoken;
import com.notionds.dataSupplier.container.Context;
import com.notionds.dataSupplier.datum.Id;
import com.notionds.dataSupplier.operational.Operational;
import com.notionds.dataSupplier.provider.Envoy;
import com.notionds.dataSupplier.rubric.Complication;

import java.util.Map;

public abstract class Support<F extends Fact<F,O,S,I,X,B>,O extends Operational<F,O,S,I,X>,S extends Support<F,O,S,I,X,B>,I extends Id<I,X>,X extends Context<X>,B extends Bus<F,O,I,X,B>> extends Container<F,S,F,O,S,I,X> {

    @Unspoken
    private B bus;
    @Unspoken
    private Map<Envoy<?,?,F,O,S,I,X>,Track[]> tracksByEnvoy;

    public Support(B bus) {
        this.bus = bus;
    }

    public void setBus(B bus) {
        this.bus = bus;
    }
    public void getComplication(Envoy<?,?,F,O,S,I,X> envoy, Class<Complication> complicationClass) {

    }
    public void add(Envoy<?,?,F,O,S,I,X> envoy, Complication<?,?,F,O,S,I,X,?,?,?> complication) {

        Envoy[] tracks_n = new Envoy[envoys.length + 1];
        for (int i = 0; i < envoys.length; i++)
            tracks_n[i] = envoys[i];
        tracks_n[envoys.length] = envoy;
        envoys = tracks_n;
    }
    public void remove(Envoy envoy)

    public B getBus() {
        return bus;
    }

    public Envoy[] getEnvoys() {
        return this.envoys;
    }
}
