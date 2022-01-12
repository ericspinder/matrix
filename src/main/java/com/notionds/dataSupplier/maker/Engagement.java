package com.notionds.dataSupplier.maker;

import com.notionds.dataSupplier.Container;
import com.notionds.dataSupplier.Unspoken;
import com.notionds.dataSupplier.context.Context;
import com.notionds.dataSupplier.datum.Datum;
import com.notionds.dataSupplier.datum.id.Session;
import com.notionds.dataSupplier.operational.Operational;

import java.util.Arrays;

public abstract class Engagement<D extends Datum<D,O,C,I>,O extends Operational<D,O>,C extends Container<D,O,C,I,?>,I extends Engagement<D,O,C,I,F>,F extends Fingerprint<F>> extends Session<D,O,C,I> {

    @Unspoken
    private final F fingerprint;

    public Engagement(String id, Context<D> context, String[] magicWords, F fingerprint) {
        super(id, context, magicWords);
        this.fingerprint = fingerprint;
    }

    @Override
    public int compareTo(I that) {
        if(this.getContext().equals(that.getContext())) {
            if (this.getId().equals(that.getId())) {
                if (this.getMagicWords().equals(that.getMagicWords())) {
                    return this.getFingerprint().compareTo(that.getFingerprint());
                }
                return Arrays.compare(this.getMagicWords(),that.getMagicWords());
            }
            return this.getId().compareTo(that.getId());
        }
        return this.getContext().compareTo(that.getContext());
    }
    public F getFingerprint() {
        return this.fingerprint;
    }
}
