package com.notionds.dataSupplier.datum.fact;

import com.notionds.dataSupplier.container.Container;
import com.notionds.dataSupplier.Unspoken;
import com.notionds.dataSupplier.container.Context;
import com.notionds.dataSupplier.datum.Id;
import com.notionds.dataSupplier.operational.Operational;
import com.notionds.dataSupplier.setting.Track;

public abstract class Support<F extends Fact<F,O,C,I,X,B>,O extends Operational<F,O>,C extends Support<F,O,C,I,X,B>,I extends Id<I,X>,X extends Context<X>,B extends Bus<F,O,I,X,B>> extends Container<F,C> {

    @Unspoken
    private B bus;
    @Unspoken
    private Track track;

    public Support(B bus, Track track) {
        this.bus = bus;
        this.track = track;
    }

    public void setBus(B bus) {
        this.bus = bus;
    }
    public void setTrack(Track track) {
        this.track = track;
    }

    public B getBus() {
        return bus;
    }

    public Track getTrack() {
        return this.track;
    }
}
