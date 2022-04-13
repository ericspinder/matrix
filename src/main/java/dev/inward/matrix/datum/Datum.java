package dev.inward.matrix.datum;

import dev.inward.matrix.datum.fact.Fact;
import dev.inward.matrix.datum.fact.notion.concept.Context;
import dev.inward.matrix.datum.fact.Progenitor;
import dev.inward.matrix.rubric.Envoy;
import dev.inward.matrix.rubric.Roller;

import java.util.Map;

public abstract class Datum<D extends Datum<D,F,I,X,P,E>,F extends Fact<F,I,X,P,?,?,?>,I extends Identity<I,X>,X extends Context<X>,P extends Progenitor<?,F,?,I,X,?,P>,E extends Envoy<?,D,F,?,I,X,?,P,E>> {

    protected Tracks<?,D,F,?,I,X,?,P,E> tracks = new Tracks(this);

    public void write(D datum) {
        for (Map.Entry<String, ? extends Tracks.Track<?, D, F, ?, I, X, ?, P, E>> entry: tracks.getTracks().entrySet()) {
            if (entry..(why, datum)) {
                try {
                    SetMethodLocal.get().invoke(datum);
                    this.tracks.afterWrite(why, datum);
                } catch (Throwable roller) {
                    this.tracks.afterExceptionalWrite(why, (Roller) roller);
                }
            } else {
                this.tracks.afterWriteFail(why, datum, this);
            }
        }

    }

    public D read() {
        boolean read = true;
        try {
            if (this.tracks.beforeRead(why, this)) {
                read = true;
                return (D) GetMethodLocal.get().invoke();
            }
            else {
                read = false;
            }
        }
        catch (Throwable roller) {
             (((Y)this.getClass().getClassLoader()).getProgenitor()).get().getBus().getManagement().handle( roller,this, );
             return null;
        }
        finally {
            this.tracks.afterRead(why,this,read);
        }
    }
    public P getProgenitor() {
        return ((Y) this.getClass().getClassLoader()).getProgenitor();
    }
    public Tracks getTrack() {
        return this.tracks;
    }

}
